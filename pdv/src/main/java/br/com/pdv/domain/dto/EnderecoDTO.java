package br.com.pdv.domain.dto;

public class EnderecoDTO {
    private String cep;
    private String cidade;
    private String estado;
    private String logradouro;
    private String bairro;
    private String numero;
    private String complemento;

    public static final class EnderecoDTOBuilder {

        private EnderecoDTO dto;

        public EnderecoDTOBuilder() {
            dto = new EnderecoDTO();
        }

        public EnderecoDTOBuilder withCep(String cep) {
            dto.cep = cep;
            return this;
        }

        public EnderecoDTOBuilder withCidade(String cidade) {
            dto.cidade = cidade;
            return this;
        }

        public EnderecoDTOBuilder withEstado(String estado) {
            dto.estado = estado;
            return this;
        }

        public EnderecoDTOBuilder withLogradouro(String logradouro) {
            dto.logradouro = logradouro;
            return this;
        }

        public EnderecoDTOBuilder withBairro(String bairro) {
            dto.bairro = bairro;
            return this;
        }

        public EnderecoDTOBuilder withNumero(String numero) {
            dto.numero = numero;
            return this;
        }

        public EnderecoDTOBuilder withComplemento(String complemento) {
            dto.complemento = complemento;
            return this;
        }

        public EnderecoDTO build() {
            return dto;
        }
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

}
