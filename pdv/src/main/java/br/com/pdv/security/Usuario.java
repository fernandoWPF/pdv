package br.com.pdv.security;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario")
public class Usuario {

    @Id
    private String id;
    private String nome;
    private String senha;
    private String[] permissoes;

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String[] getPermissoes() {
        return permissoes;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Usuario [nome=");
        builder.append(nome);
        builder.append(", permissoes=");
        builder.append(permissoes);
        builder.append("]");
        return builder.toString();
    }

}
