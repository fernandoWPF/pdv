package br.com.pdv.service.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.util.Arrays;
import org.springframework.stereotype.Component;

import br.com.pdv.domain.Sexo;
import br.com.pdv.domain.dto.ClienteRequestDTO;
import br.com.pdv.service.exception.BusinessException;

@Component
public class ClienteValidator implements Validator<ClienteRequestDTO>{
    
    private static final Logger LOG = LogManager.getLogger(ClienteValidator.class);

    public void validate(ClienteRequestDTO request) {
        LOG.debug("Request recebido: {}", request);
        validaSexo(request.getSexo());
        LOG.debug("Request validado.");
    }

    private void validaSexo(String sexo) {
        if(!Arrays.asList(Sexo.values()).contains(Sexo.valueOf(sexo))) {
            throw new BusinessException("Valor invalido para Sexo.");
        }
    }

}
