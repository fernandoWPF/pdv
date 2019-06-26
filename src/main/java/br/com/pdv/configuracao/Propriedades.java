package br.com.pdv.configuracao;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.pdv.repository.ConfiguracaoRepository;

@Component
public class Propriedades {

    private static final Logger LOG = LogManager.getLogger(Propriedades.class);
    private static final String TIMEZONE_DEFAULT = "UTC"; 

    @Autowired
    private ConfiguracaoRepository configuracaoRepository;
    private static Map<String, String> configuracoes = new HashMap<>();

    @PostConstruct
    public void inicializar() {
        LOG.debug("Inicializando configuracoes...");
        
        configuracaoRepository.findAll().stream()
                .forEach(config -> configuracoes.put(config.getChave(), config.getValor()));
        
        setTimezone(configuracoes.get("timezone"));
        
        LOG.debug("Configuracoes inicializadas.");
    }

    public static String get(String chave) {
        if(!configuracoes.containsKey(chave)) {
            LOG.warn("Configuracao {} nao localizada", chave);
        }
        return configuracoes.get(chave);
    }
    
    private void setTimezone(String timezone) {
        TimeZone.setDefault(TimeZone.getTimeZone(Objects.isNull(timezone) ? TIMEZONE_DEFAULT : timezone));
        LOG.debug("Timezone setado para {}", TimeZone.getDefault());
    }

}
