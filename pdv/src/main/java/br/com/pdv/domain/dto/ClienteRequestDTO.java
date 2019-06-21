package br.com.pdv.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

public class ClienteRequestDTO {

    @NotBlank
    private String nome;
    @CPF
    private String cpf;
    @NotBlank
    private String sexo;
    @Pattern(regexp = "\\d{8}")
    private String cep;
    @NotNull
    private Integer numeroEndereco;
    private String complementoEndereco;

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public String getCep() {
        return cep;
    }

    public Integer getNumeroEndereco() {
        return numeroEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
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
