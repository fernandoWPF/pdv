package br.com.pdv.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.pdv.domain.Endereco;
import br.com.pdv.domain.dto.CepResponseDTO;
import br.com.pdv.domain.dto.ClienteRequestDTO;
import br.com.pdv.utils.CepUtils;

@Component
public class EnderecoAdapter {

    @Autowired
    private CepUtils cepUtils;
    
    public Endereco requestToEntity(ClienteRequestDTO request) {
        CepResponseDTO cepResponse = cepUtils.buscaCepViaWebService(request.getCep());
        
        return new Endereco.EnderecoBuilder()
                .withCidade(cepResponse.getLocalidade())
                .withEstado(cepResponse.getUf())
                .withLogradouro(cepResponse.getLogradouro())
                .withBairro(cepResponse.getBairro())
                .withCep(cepResponse.getCep())
                .withNumero(request.getNumeroEndereco())
                .withComplemento(request.getComplementoEndereco())
                .build();
    }
    
}
