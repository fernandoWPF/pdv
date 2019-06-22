package br.com.pdv.domain.dto;

public class EnderecoDTO {
    private String cep;
    private String cidade;
    private String estado;
    private String logradouro;
    private String bairro;
    private Integer numero;
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

        public EnderecoDTOBuilder withNumero(Integer numero) {
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

    public Integer getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EnderecoDTO [cep=");
        builder.append(cep);
        builder.append(", cidade=");
        builder.append(cidade);
        builder.append(", estado=");
        builder.append(estado);
        builder.append(", logradouro=");
        builder.append(logradouro);
        builder.append(", bairro=");
        builder.append(bairro);
        builder.append(", numero=");
        builder.append(numero);
        builder.append(", complemento=");
        builder.append(complemento);
        builder.append("]");
        return builder.toString();
    }

}
