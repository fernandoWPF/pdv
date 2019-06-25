package br.com.pdv.security;

import java.util.List;

public class Usuario {

    private String nome;
    private String senha;
    private List<String> permissoes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<String> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<String> permissoes) {
        this.permissoes = permissoes;
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
