package br.com.pdv.domain.dto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ClienteResponseDTOTest {

    @Test
    public void deveValidarClienteResponseDTONaoNulo() {
        ClienteResponseDTO dto = new ClienteResponseDTO.ClienteResponseDTOBuilder().build();

        Assert.assertNotNull(dto);
    }

    @Test
    public void deveValidarNome() {
        ClienteResponseDTO dto = new ClienteResponseDTO.ClienteResponseDTOBuilder().withNome("Jarbas").build();

        String nome = "Jarbas";

        Assert.assertEquals(nome, dto.getNome());
    }

    @Test
    public void deveValidarCpf() {
        ClienteResponseDTO dto = new ClienteResponseDTO.ClienteResponseDTOBuilder().withCpf("08454878965").build();

        String cpf = "08454878965";

        Assert.assertEquals(cpf, dto.getCpf());
    }

    @Test
    public void deveValidarSexo() {
        ClienteResponseDTO dto = new ClienteResponseDTO.ClienteResponseDTOBuilder().withSexo("F").build();

        String sexo = "F";

        Assert.assertEquals(sexo, dto.getSexo());
    }

    @Test
    public void deveValidarDataCadastro() {
        ClienteResponseDTO dto = new ClienteResponseDTO.ClienteResponseDTOBuilder()
                .withDataCadastro("01/01/1990 23:56:45.5890").build();

        String dataCadastro = "01/01/1990 23:56:45.5890";

        Assert.assertEquals(dataCadastro, dto.getDataCadastro());
    }

    @Test
    public void deveValidarDataAlteracao() {
        ClienteResponseDTO dto = new ClienteResponseDTO.ClienteResponseDTOBuilder()
                .withDataAlteracao("01/01/1997 23:45:45.5890").build();

        String dataAlteracao = "01/01/1997 23:45:45.5890";

        Assert.assertEquals(dataAlteracao, dto.getDataAlteracao());
    }

    @Test
    public void deveValidarEndereco() {
        EnderecoDTO endereco = new EnderecoDTO.EnderecoDTOBuilder().build();
        ClienteResponseDTO dto = new ClienteResponseDTO.ClienteResponseDTOBuilder().withEndereco(endereco).build();

        Assert.assertEquals(endereco, dto.getEndereco());
    }

}
