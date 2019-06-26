package br.com.pdv.domain.dto;

public class ErrorDTO {

    private String mensagem;

    public ErrorDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMessage() {
        return mensagem;
    }

}
