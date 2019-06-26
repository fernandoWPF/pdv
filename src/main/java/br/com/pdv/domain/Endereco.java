package br.com.pdv.domain;

public class Endereco {

    private String cep;
    private String cidade;
    private String estado;
    private String logradouro;
    private String bairro;
    private Integer numero;
    private String complemento;

    public static final class EnderecoBuilder {

        private Endereco endereco;

        public EnderecoBuilder() {
            endereco = new Endereco();
        }

        public EnderecoBuilder withCep(String cep) {
            endereco.cep = cep;
            return this;
        }

        public EnderecoBuilder withCidade(String cidade) {
            endereco.cidade = cidade;
            return this;
        }

        public EnderecoBuilder withEstado(String estado) {
            endereco.estado = estado;
            return this;
        }

        public EnderecoBuilder withLogradouro(String logradouro) {
            endereco.logradouro = logradouro;
            return this;
        }

        public EnderecoBuilder withBairro(String bairro) {
            endereco.bairro = bairro;
            return this;
        }

        public EnderecoBuilder withNumero(Integer numero) {
            endereco.numero = numero;
            return this;
        }

        public EnderecoBuilder withComplemento(String complemento) {
            endereco.complemento = complemento;
            return this;
        }

        public Endereco build() {
            return endereco;
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
        builder.append("Endereco [cep=");
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
