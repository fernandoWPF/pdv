package br.com.pdv.domain.dto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EnderecoDTOTest {

    @Test
    public void deveValidarEnderecoNaoNulo() {
        EnderecoDTO dto = new EnderecoDTO.EnderecoDTOBuilder().build();

        Assert.assertNotNull(dto);
    }

    @Test
    public void deveValidarCep() {
        EnderecoDTO dto = new EnderecoDTO.EnderecoDTOBuilder().withCep("117542000").build();

        String cep = "117542000";

        Assert.assertEquals(cep, dto.getCep());
    }

    @Test
    public void deveValidarCidade() {
        EnderecoDTO dto = new EnderecoDTO.EnderecoDTOBuilder().withCidade("Maringá").build();

        String cidade = "Maringá";

        Assert.assertEquals(cidade, dto.getCidade());
    }

    @Test
    public void deveValidarEstado() {
        EnderecoDTO dto = new EnderecoDTO.EnderecoDTOBuilder().withEstado("Paraná").build();

        String estado = "Paraná";

        Assert.assertEquals(estado, dto.getEstado());
    }

    @Test
    public void deveValidarLogradouro() {
        EnderecoDTO dto = new EnderecoDTO.EnderecoDTOBuilder().withLogradouro("Rua X").build();

        String logradouro = "Rua X";

        Assert.assertEquals(logradouro, dto.getLogradouro());
    }

    @Test
    public void deveValidarBairro() {
        EnderecoDTO dto = new EnderecoDTO.EnderecoDTOBuilder().withBairro("Bairro").build();

        String bairro = "Bairro";

        Assert.assertEquals(bairro, dto.getBairro());
    }

    @Test
    public void deveValidarNumero() {
        EnderecoDTO dto = new EnderecoDTO.EnderecoDTOBuilder().withNumero(456).build();

        Integer numero = 456;

        Assert.assertEquals(numero, dto.getNumero());
    }

    @Test
    public void deveValidarComplemento() {
        EnderecoDTO dto = new EnderecoDTO.EnderecoDTOBuilder().withComplemento("Complemento").build();

        String complemento = "Complemento";

        Assert.assertEquals(complemento, dto.getComplemento());
    }

}
