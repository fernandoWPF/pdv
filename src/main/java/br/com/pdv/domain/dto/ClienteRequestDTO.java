package br.com.pdv.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

public class ClienteRequestDTO {

    @NotBlank
    private String nome;
    @CPF(message = "CPF invalido")
    private String cpf;
    @NotBlank
    private String sexo;
    @NotBlank
    @Pattern(regexp = "\\d{8}", message = "Cep invalido")
    private String cep;
    @NotNull
    private Integer numeroEndereco;
    private String complementoEndereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(Integer numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ClienteRequestDTO [nome=");
        builder.append(nome);
        builder.append(", cpf=");
        builder.append(cpf);
        builder.append(", sexo=");
        builder.append(sexo);
        builder.append(", cep=");
        builder.append(cep);
        builder.append(", numeroEndereco=");
        builder.append(numeroEndereco);
        builder.append(", complementoEndereco=");
        builder.append(complementoEndereco);
        builder.append("]");
        return builder.toString();
    }

}
