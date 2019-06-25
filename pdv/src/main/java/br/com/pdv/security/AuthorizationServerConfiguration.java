package br.com.pdv.security;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

import br.com.pdv.configuracao.Propriedades;
import br.com.pdv.exception.BusinessException;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    private static final Logger LOG = LogManager.getLogger(AuthorizationServerConfiguration.class);

    private static final String GRANT_TYPES = "client_credentials";
    private static final String SCOPES = "app";
    private static final String CHAVE_PRAZO_TOKEN = "oauth2.prazo.token";

    @Autowired
    private Credenciais credenciais;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        inicializaCredenciais(clients.inMemory());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    private void inicializaCredenciais(InMemoryClientDetailsServiceBuilder inMemory) {

        LOG.debug("Carregando dados de credenciais oAuth2...");

        final Integer prazoToken = Integer.valueOf(Propriedades.get(CHAVE_PRAZO_TOKEN));

        LOG.debug("Prazo para expiração de token: {} segundos", prazoToken);

        ClientDetailsServiceBuilder<InMemoryClientDetailsServiceBuilder>.ClientBuilder clientBuilder;
        
        List<Usuario> usuarios = credenciais.getUsuarios();
        
        if(usuarios.isEmpty()) {
            throw new BusinessException("Nenhum ususario configurado para acessar os servicos.");
        }
        
        LOG.debug("{} usuario(s) configurado(s): {}", usuarios.size(), usuarios);
        
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        clientBuilder = inMemory
                .withClient(usuarios.get(0).getNome())
                .secret(passwordEncoder.encode(usuarios.get(0).getSenha()))
                .authorities(usuarios.get(0).getPermissoes().toArray(new String[usuarios.get(0).getPermissoes().size()]))
                .authorizedGrantTypes(GRANT_TYPES)
                .accessTokenValiditySeconds(prazoToken)
                .scopes(SCOPES);

        usuarios.remove(0);

        for (Usuario usuario : usuarios) {
            clientBuilder.and()
                .withClient(usuario.getNome())
                .secret(passwordEncoder.encode(usuario.getSenha()))
                .authorities(usuario.getPermissoes().toArray(new String[usuario.getPermissoes().size()]))
                .authorizedGrantTypes(GRANT_TYPES)
                .accessTokenValiditySeconds(prazoToken)
                .scopes(SCOPES);
        }

        LOG.debug("OAuth2 configurado.");

    }

}
