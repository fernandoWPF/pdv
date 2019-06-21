package br.com.pdv.adapter;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.pdv.domain.Cliente;
import br.com.pdv.domain.Endereco;
import br.com.pdv.domain.Sexo;
import br.com.pdv.domain.dto.ClienteRequestDTO;
import br.com.pdv.domain.dto.ClienteResponseDTO;

@Component
public class ClienteAdapter {

    @Autowired
    private EnderecoAdapter enderecoAdapter;
    
    public Cliente requestToEntity(ClienteRequestDTO request) {
        Endereco endereco = enderecoAdapter.requestToEntity(request);
        return new Cliente.ClienteBuilder()
                .withCpf(request.getCpf())
                .withDataCadastro(LocalDate.now())
                .withNome(request.getNome())
                .withSexo(Sexo.valueOf(request.getSexo()))
                .withEndereco(endereco)
                .build();
    }
    
    public ClienteResponseDTO entityToResponse() {
        
    }
    
}
