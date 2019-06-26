package br.com.pdv.service;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.pdv.configuracao.Propriedades;
import br.com.pdv.domain.Cliente;
import br.com.pdv.domain.Endereco;
import br.com.pdv.domain.Sexo;
import br.com.pdv.domain.dto.ClienteRequestDTO;
import br.com.pdv.domain.dto.ClienteResponseDTO;
import br.com.pdv.repository.ClienteRepository;

@DataMongoTest
@RunWith(PowerMockRunner.class)
@PrepareForTest(Propriedades.class)
@PowerMockRunnerDelegate(SpringRunner.class)
@PowerMockIgnore({"javax.script.*", "javax.management.*", "org.w3c.dom.*", "org.apache.log4j.*", "org.xml.sax.*",   "javax.xml.*"})
@ComponentScan({"br.com.pdv.*"})
public class ClienteServiceTest {

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private ClienteService service;
    private ClienteRequestDTO request;
    private Cliente cliente;
    private Endereco endereco;
    
    @Before
    public void setUp(){
        
        request = new ClienteRequestDTO();
        request.setNome("Joana");
        request.setCpf("08525865947");
        request.setSexo("F");
        request.setCep("01001000");
        
        endereco = new Endereco.EnderecoBuilder()
                .withBairro("Sé")
                .withCep("01001-000")
                .withCidade("São Paulo")
                .withEstado("SP")
                .withLogradouro("Praça da Sé")
                .build();
        
        cliente = new Cliente.ClienteBuilder()
                .withNome("Joana")
                .withCpf("08525865947")
                .withSexo(Sexo.F)
                .withEndereco(endereco)
                .build();
        
        PowerMockito.mockStatic(Propriedades.class);
        PowerMockito.when(Propriedades.get("cep.url")).thenReturn("https://viacep.com.br/ws");
        
    }

    @Test
    public void deveSalvar() {

        repository.deleteAll();
        
        service.salvar(request);

        Assert.assertEquals(1, repository.count());
        
        Cliente clienteSalvo = repository.findAll().get(0);
        Endereco enderecoSalvo = clienteSalvo.getEndereco();
        
        Assert.assertNotNull(clienteSalvo.getId());
        Assert.assertEquals(clienteSalvo.getNome(), cliente.getNome());
        Assert.assertEquals(clienteSalvo.getCpf(), cliente.getCpf());
        Assert.assertEquals(clienteSalvo.getSexo(), cliente.getSexo());
        Assert.assertEquals(enderecoSalvo.getNumero(), cliente.getEndereco().getNumero());
        
        Assert.assertEquals(enderecoSalvo.getBairro(), endereco.getBairro());
        Assert.assertEquals(enderecoSalvo.getCep(), endereco.getCep());
        Assert.assertEquals(enderecoSalvo.getCidade(), endereco.getCidade());
        Assert.assertEquals(enderecoSalvo.getEstado(), endereco.getEstado());
        Assert.assertEquals(enderecoSalvo.getLogradouro(), endereco.getLogradouro());

    }

    @Test
    public void deveBuscarTodos() {

        repository.deleteAll();
        
        Cliente cliente1 = cliente = new Cliente.ClienteBuilder()
                .withNome("Rosilda")
                .withCpf("08525865945")
                .withSexo(Sexo.F)
                .withEndereco(endereco)
                .build();
        
        Cliente cliente2 = cliente = new Cliente.ClienteBuilder()
                .withNome("Mariana")
                .withCpf("08525865948")
                .withSexo(Sexo.F)
                .withEndereco(endereco)
                .build();
        
        repository.save(cliente1);
        repository.save(cliente2);
        
        List<ClienteResponseDTO> response = service.buscarTodos();
        
        Assert.assertNotNull(response);
        Assert.assertEquals(2, response.size());
        
    }

    @Test
    public void deveAlterar() {
        
        repository.deleteAll();
        
        Cliente clienteSalvo = repository.save(cliente);
        
        request.setNome("Maria");
        
        service.alterar(clienteSalvo.getId(), request);
        
        Optional<Cliente> clienteAlterado = repository.findById(clienteSalvo.getId());
        
        if(clienteAlterado.isPresent()) {
            Assert.assertNotNull(clienteAlterado.get().getId());
            Assert.assertEquals(clienteAlterado.get().getNome(), "Maria");
            Assert.assertEquals(clienteAlterado.get().getCpf(), cliente.getCpf());
            Assert.assertEquals(clienteAlterado.get().getSexo(), cliente.getSexo());
        }
        
    }

    @Test
    public void deveExcluir() {

        repository.deleteAll();
        
        repository.save(cliente);
        
        Cliente clienteSalvo = repository.findAll().get(0);
        
        Assert.assertEquals(1, repository.count());
        
        service.excluir(clienteSalvo.getId());
        
        Assert.assertEquals(0, repository.count());
        
    }
}
