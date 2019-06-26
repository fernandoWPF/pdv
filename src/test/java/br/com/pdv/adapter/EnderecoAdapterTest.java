package br.com.pdv.adapter;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.com.pdv.configuracao.Propriedades;
import br.com.pdv.domain.Endereco;
import br.com.pdv.domain.dto.ClienteRequestDTO;
import br.com.pdv.domain.dto.EnderecoDTO;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Propriedades.class)
@PowerMockIgnore({"javax.script.*", "javax.management.*", "org.w3c.dom.*", "org.apache.log4j.*", "org.xml.sax.*",   "javax.xml.*"})
public class EnderecoAdapterTest {

    private Endereco endereco;
    private EnderecoAdapter adapter;
    @Spy
    private ClienteRequestDTO request = new ClienteRequestDTO();
    
    @Before
    public void setUp() {
        adapter = new EnderecoAdapter();
        
        endereco = new Endereco.EnderecoBuilder()
                .withBairro("Sé")
                .withCep("01001-000")
                .withCidade("São Paulo")
                .withEstado("SP")
                .withLogradouro("Praça da Sé")
                .build();
        
        PowerMockito.mockStatic(Propriedades.class);
    }
    
    @Test
    public void deveValidarRequestToEntity() {
        
        PowerMockito.when(request.getCep()).thenReturn("01001000");
        PowerMockito.when(Propriedades.get("cep.url")).thenReturn("https://viacep.com.br/ws");
        
        Endereco entity = adapter.requestToEntity(request);
        
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getBairro(), endereco.getBairro());
        Assert.assertEquals(entity.getCep(), endereco.getCep());
        Assert.assertEquals(entity.getCidade(), endereco.getCidade());
        Assert.assertEquals(entity.getEstado(), endereco.getEstado());
        Assert.assertEquals(entity.getLogradouro(), endereco.getLogradouro());
    }

    @Test
    public void deveValidarEntityToResponseListDeEnderecoDTO() {
        List<Endereco> enderecos = new ArrayList<>();
        
        enderecos.add(endereco);
        
        List<EnderecoDTO> enderecosDTO = adapter.entityToResponse(enderecos);
        
        Assert.assertNotNull(enderecosDTO);
        Assert.assertEquals(enderecos.get(0).getBairro(), endereco.getBairro());
        Assert.assertEquals(enderecos.get(0).getCep(), endereco.getCep());
        Assert.assertEquals(enderecos.get(0).getCidade(), endereco.getCidade());
        Assert.assertEquals(enderecos.get(0).getEstado(), endereco.getEstado());
        Assert.assertEquals(enderecos.get(0).getLogradouro(), endereco.getLogradouro());
        
    }

    @Test
    public void deveValidarEntityToResponseEndereco() {
        EnderecoDTO enderecoDTO = adapter.entityToResponse(endereco);
        
        Assert.assertNotNull(enderecoDTO);
        Assert.assertEquals(enderecoDTO.getBairro(), endereco.getBairro());
        Assert.assertEquals(enderecoDTO.getCep(), endereco.getCep());
        Assert.assertEquals(enderecoDTO.getCidade(), endereco.getCidade());
        Assert.assertEquals(enderecoDTO.getEstado(), endereco.getEstado());
        Assert.assertEquals(enderecoDTO.getLogradouro(), endereco.getLogradouro());
    }

}
