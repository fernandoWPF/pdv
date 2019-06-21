package br.com.pdv.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.pdv.domain.dto.CepResponseDTO;

@Component
public class CepUtils {

    private static final Logger LOG = LogManager.getLogger(CepUtils.class);
    private static final String FORMATO_RESPONSE = "json";

    @Value("${cep.url}")
    private String urlCep;
    
    public CepResponseDTO buscaCepViaWebService(String cep) {
        String url = montaUrl(cep);
        LOG.info("Fazendo requisicao para buscar CEP: {}", url);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(url, CepResponseDTO.class).getBody();
    }

    private String montaUrl(String cep) {
        StringBuilder sb = new StringBuilder();
        sb.append(urlCep);
        sb.append("/");
        sb.append(cep);
        sb.append("/");
        sb.append(FORMATO_RESPONSE);
        return String.valueOf(sb);
    }
    
}
