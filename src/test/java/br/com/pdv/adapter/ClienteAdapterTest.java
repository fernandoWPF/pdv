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
import br.com.pdv.domain.Cliente;
import br.com.pdv.domain.Endereco;
import br.com.pdv.domain.Sexo;
import br.com.pdv.domain.dto.ClienteRequestDTO;
import br.com.pdv.domain.dto.ClienteResponseDTO;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Propriedades.class)
@PowerMockIgnore({"javax.script.*", "javax.management.*", "org.w3c.dom.*", "org.apache.log4j.*", "org.xml.sax.*",   "javax.xml.*"})
public class ClienteAdapterTest {

    private ClienteAdapter adapter;
    private Cliente cliente;
    @Spy
    private ClienteRequestDTO request = new ClienteRequestDTO();
    
    @Before
    public void setUp(){
        adapter = new ClienteAdapter();
        Endereco endereco = new Endereco.EnderecoBuilder().withNumero(45).build();
        cliente = new Cliente.ClienteBuilder()
                .withNome("Joana")
                .withCpf("08525865947")
                .withSexo(Sexo.F)
                .withEndereco(endereco)
                .build();
        PowerMockito.mockStatic(Propriedades.class);
    }
    
    @Test
    public void deveValidarEntityToResponseListaDeClienteNaoNulo() {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente);
        List<ClienteResponseDTO> responses = adapter.entityToResponse(clientes);
        
        Assert.assertNotNull(responses);
    }
    
    @Test
    public void deveValidarEntityToResponseListaDeClienteComAtributoNomeIguais() {
        List<Cliente> clientes = new ArrayList<>();
        
        clientes.add(cliente);
        
        List<ClienteResponseDTO> responses = adapter.entityToResponse(clientes);
        
        Assert.assertEquals(responses.get(0).getNome(), cliente.getNome());
        Assert.assertEquals(responses.get(0).getCpf(), cliente.getCpf());
        Assert.assertEquals(responses.get(0).getSexo(), String.valueOf(cliente.getSexo()));
    }

    @Test
    public void deveValidarRequestToEntity() {
        
        PowerMockito.when(request.getNome()).thenReturn("Joana");
        PowerMockito.when(request.getSexo()).thenReturn("F");
        PowerMockito.when(request.getCpf()).thenReturn("08525865947");
        PowerMockito.when(request.getCep()).thenReturn("01001000");
        PowerMockito.when(request.getNumeroEndereco()).thenReturn(45);
        PowerMockito.when(Propriedades.get("cep.url")).thenReturn("https://viacep.com.br/ws");
        
        Cliente entity = adapter.requestToEntity(request);
        
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getNome(), cliente.getNome());
        Assert.assertEquals(entity.getCpf(), cliente.getCpf());
        Assert.assertEquals(entity.getSexo(), cliente.getSexo());
        Assert.assertEquals(entity.getEndereco().getNumero(), cliente.getEndereco().getNumero());
    }

    /*@Test
    public void deveValidarEntityToResponseDeCliente() {
        fail("Not yet implemented");
    }

    @Test
    public void deveValidarRequestUpdateToEntity() {
        fail("Not yet implemented");
    }*/

}
