package br.com.pdv.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EnderecoTest {

    @Test
    public void deveValidarCriacaoDeEnderecoNaoNulo() {
        Endereco endereco = new Endereco.EnderecoBuilder().build();
        
        Assert.assertNotNull(endereco);
    }
    
    @Test
    public void deveValidarCep() {
        Endereco endereco = new Endereco.EnderecoBuilder().withCep("87114540").build();

        String cep = "87114540";

        Assert.assertEquals(cep, endereco.getCep());
    }

    @Test
    public void deveValidarCidade() {
        Endereco endereco = new Endereco.EnderecoBuilder().withCidade("Maringá").build();

        String cidade = "Maringá";

        Assert.assertEquals(cidade, endereco.getCidade());
    }

    @Test
    public void deveValidarEstado() {
        Endereco endereco = new Endereco.EnderecoBuilder().withEstado("Paraná").build();

        String estado = "Paraná";

        Assert.assertEquals(estado, endereco.getEstado());
    }

    @Test
    public void deveValidarLogradouro() {
        Endereco endereco = new Endereco.EnderecoBuilder().withLogradouro("Rua X").build();

        String logradouro = "Rua X";

        Assert.assertEquals(logradouro, endereco.getLogradouro());
    }

    @Test
    public void deveValidarBairro() {
        Endereco endereco = new Endereco.EnderecoBuilder().withBairro("Bairro X").build();

        String bairro = "Bairro X";

        Assert.assertEquals(bairro, endereco.getBairro());
    }

    @Test
    public void deveValidarNumero() {
        Endereco endereco = new Endereco.EnderecoBuilder().withNumero(578).build();

        Integer numero = 578;

        Assert.assertEquals(numero, endereco.getNumero());
    }

    @Test
    public void deveValidarComplemento() {
        Endereco endereco = new Endereco.EnderecoBuilder().withComplemento("s/n").build();

        String complemento = "s/n";

        Assert.assertEquals(complemento, endereco.getComplemento());
    }
}
