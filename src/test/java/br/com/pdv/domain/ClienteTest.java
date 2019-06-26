package br.com.pdv.domain;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ClienteTest {

    @Test
    public void deveValidarCriacaoDeClienteNaoNulo() {
        Cliente cliente = new Cliente.ClienteBuilder().build();
        
        Assert.assertNotNull(cliente);
    }
    
    @Test
    public void deveValidarNome() {
        Cliente cliente = new Cliente.ClienteBuilder().withNome("JOAO").build();

        String nome = "JOAO";

        Assert.assertEquals(nome, cliente.getNome());
    }

    @Test
    public void deveValidarCpf() {
        Cliente cliente = new Cliente.ClienteBuilder().withCpf("12345678").build();

        String cpf = "12345678";

        Assert.assertEquals(cpf, cliente.getCpf());
    }

    @Test
    public void deveValidarSexo() {
        Cliente cliente = new Cliente.ClienteBuilder().withSexo(Sexo.F).build();

        Sexo sexo = Sexo.F;

        Assert.assertEquals(sexo, cliente.getSexo());
    }

    @Test
    public void deveValidarDataCadastro() {
        LocalDateTime agora = LocalDateTime.now();
        Cliente cliente = new Cliente.ClienteBuilder().withDataCadastro(agora).build();

        Assert.assertEquals(agora, cliente.getDataCadastro());
    }

    @Test
    public void deveValidarDataAlteracao() {
        LocalDateTime agora = LocalDateTime.now();
        Cliente cliente = new Cliente.ClienteBuilder().withDataAlteracao(agora).build();

        Assert.assertEquals(agora, cliente.getDataAlteracao());
    }

    @Test
    public void deveValidarEndereco() {
        Endereco endereco = new Endereco.EnderecoBuilder().withBairro("Bairro").withCep("87114540").build();
        Cliente cliente = new Cliente.ClienteBuilder().withEndereco(endereco).build();

        Assert.assertEquals(endereco, cliente.getEndereco());
    }
    
    @Test
    public void deveValidarMetodoForUpdate() {
        Cliente cliente1 = new Cliente.ClienteBuilder().build();
        
        Cliente cliente2 = new Cliente.ClienteBuilder().forUpdate(cliente1).build();
        
        Assert.assertEquals(cliente1, cliente2);
    }
}
