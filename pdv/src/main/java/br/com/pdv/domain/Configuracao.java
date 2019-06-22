package br.com.pdv.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "configuracao")
public class Configuracao {

    @Id
    private String id;
    private String chave;
    private String valor;

    public String getId() {
        return id;
    }

    public String getChave() {
        return chave;
    }

    public String getValor() {
        return valor;
    }

}
