package br.com.pdv.domain.dto;

public class CepResponseDTO {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String unidade;
    private String ibge;
    private String gia;
    private String erro;

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public String getUnidade() {
        return unidade;
    }

    public String getIbge() {
        return ibge;
    }

    public String getGia() {
        return gia;
    }

    public String getErro() {
        return erro;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CepResponseDTO [cep=");
        builder.append(cep);
        builder.append(", logradouro=");
        builder.append(logradouro);
        builder.append(", complemento=");
        builder.append(complemento);
        builder.append(", bairro=");
        builder.append(bairro);
        builder.append(", localidade=");
        builder.append(localidade);
        builder.append(", uf=");
        builder.append(uf);
        builder.append(", unidade=");
        builder.append(unidade);
        builder.append(", ibge=");
        builder.append(ibge);
        builder.append(", gia=");
        builder.append(gia);
        builder.append(", erro=");
        builder.append(erro);
        builder.append("]");
        return builder.toString();
    }

}
