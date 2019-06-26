package br.com.pdv.domain.dto;

public class ClienteResponseDTO {

    private String id;
    private String nome;
    private String cpf;
    private String sexo;
    private String dataCadastro;
    private String dataAlteracao;
    private EnderecoDTO endereco;

    public static final class ClienteResponseDTOBuilder {
        private ClienteResponseDTO dto;

        public ClienteResponseDTOBuilder() {
            dto = new ClienteResponseDTO();
        }

        public ClienteResponseDTOBuilder withId(String id) {
            dto.id = id;
            return this;
        }

        public ClienteResponseDTOBuilder withNome(String nome) {
            dto.nome = nome;
            return this;
        }

        public ClienteResponseDTOBuilder withCpf(String cpf) {
            dto.cpf = cpf;
            return this;
        }

        public ClienteResponseDTOBuilder withSexo(String sexo) {
            dto.sexo = sexo;
            return this;
        }

        public ClienteResponseDTOBuilder withDataCadastro(String dataCadastro) {
            dto.dataCadastro = dataCadastro;
            return this;
        }

        public ClienteResponseDTOBuilder withDataAlteracao(String dataAlteracao) {
            dto.dataAlteracao = dataAlteracao;
            return this;
        }

        public ClienteResponseDTOBuilder withEndereco(EnderecoDTO endereco) {
            dto.endereco = endereco;
            return this;
        }

        public ClienteResponseDTO build() {
            return dto;
        }
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public String getDataAlteracao() {
        return dataAlteracao;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

}
