package br.com.pdv.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cliente")
public class Cliente {

    @Id
    private String id;
    private String nome;
    private String cpf;
    private Sexo sexo;
    private LocalDateTime dataCadastro;
    private Endereco endereco;
    private LocalDateTime dataAlteracao;

    public static final class ClienteBuilder {
        private Cliente cliente;

        public ClienteBuilder() {
            cliente = new Cliente();
        }

        public ClienteBuilder withId(String id) {
            cliente.id = id;
            return this;
        }

        public ClienteBuilder withNome(String nome) {
            cliente.nome = nome;
            return this;
        }

        public ClienteBuilder withCpf(String cpf) {
            cliente.cpf = cpf;
            return this;
        }

        public ClienteBuilder withSexo(Sexo sexo) {
            cliente.sexo = sexo;
            return this;
        }

        public ClienteBuilder withDataCadastro(LocalDateTime dataCadastro) {
            cliente.dataCadastro = dataCadastro;
            return this;
        }

        public ClienteBuilder withEndereco(Endereco endereco) {
            cliente.endereco = endereco;
            return this;
        }

        public ClienteBuilder withDataAlteracao(LocalDateTime dataAlteracao) {
            cliente.dataAlteracao = dataAlteracao;
            return this;
        }

        public ClienteBuilder forUpdate(Cliente cliente) {
            this.cliente = cliente;
            return this;
        }

        public Cliente build() {
            return cliente;
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

    public Sexo getSexo() {
        return sexo;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Cliente [id=");
        builder.append(id);
        builder.append(", nome=");
        builder.append(nome);
        builder.append(", cpf=");
        builder.append(cpf);
        builder.append(", sexo=");
        builder.append(sexo);
        builder.append(", dataCadastro=");
        builder.append(dataCadastro);
        builder.append(", endereco=");
        builder.append(endereco);
        builder.append(", dataAlteracao=");
        builder.append(dataAlteracao);
        builder.append("]");
        return builder.toString();
    }

}
