package br.com.pdv.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cliente")
public class Cliente {

    @Id
    private String id;
    private String nome;
    private String cpf;
    private Sexo sexo;
    private LocalDate dataCadastro;
    private Endereco endereco;

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

        public ClienteBuilder withDataCadastro(LocalDate dataCadastro) {
            cliente.dataCadastro = dataCadastro;
            return this;
        }

        public ClienteBuilder withEndereco(Endereco endereco) {
            cliente.endereco = endereco;
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

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

}
