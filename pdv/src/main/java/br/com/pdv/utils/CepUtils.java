package br.com.pdv.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import br.com.pdv.configuracao.Propriedades;
import br.com.pdv.domain.dto.CepResponseDTO;
import br.com.pdv.exception.BusinessException;
import io.micrometer.core.instrument.util.StringUtils;

public class CepUtils {

    private static final Logger LOG = LogManager.getLogger(CepUtils.class);
    private static final String FORMATO_RESPONSE = "json";
    private static final String CHAVE_URL_CEP = "cep.url";

    public CepResponseDTO buscaCepViaWebService(String cep) {
        if(StringUtils.isBlank(cep)) {
            throw new BusinessException("Cep nao pode ser vazio");
        }
        String url = montaUrl(cep);
        LOG.info("Fazendo requisicao para buscar CEP: {}", url);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(url, CepResponseDTO.class).getBody();
    }

    private String montaUrl(String cep) {
        String urlCep = Propriedades.get(CHAVE_URL_CEP);

        StringBuilder sb = new StringBuilder();
        sb.append(urlCep);
        sb.append("/");
        sb.append(cep);
        sb.append("/");
        sb.append(FORMATO_RESPONSE);
        return String.valueOf(sb);
    }

}
