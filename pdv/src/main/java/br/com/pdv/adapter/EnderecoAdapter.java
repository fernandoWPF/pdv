package br.com.pdv.adapter;

import java.util.ArrayList;
import java.util.List;

import br.com.pdv.domain.Endereco;
import br.com.pdv.domain.dto.CepResponseDTO;
import br.com.pdv.domain.dto.ClienteRequestDTO;
import br.com.pdv.domain.dto.EnderecoDTO;
import br.com.pdv.utils.CepUtils;

public class EnderecoAdapter implements Adapter<Endereco, ClienteRequestDTO, EnderecoDTO>{
    
    @Override
    public Endereco requestToEntity(ClienteRequestDTO request) {
        CepUtils cepUtils = new CepUtils();
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

    @Override
    public List<EnderecoDTO> entityToResponse(List<Endereco> entiies) {
        List<EnderecoDTO> dtos = new ArrayList<>();
        
        for(Endereco endereco : entiies) {
            EnderecoDTO enderecoDTO = enderecoToEnderecoDTO(endereco);
            dtos.add(enderecoDTO);
        }
        return dtos;
    }

    @Override
    public EnderecoDTO entityToResponse(Endereco entity) {
        return enderecoToEnderecoDTO(entity);
    }
    
    private EnderecoDTO enderecoToEnderecoDTO(Endereco endereco) {
        return new EnderecoDTO.EnderecoDTOBuilder()
                .withBairro(endereco.getBairro())
                .withCep(endereco.getCep())
                .withCidade(endereco.getCidade())
                .withComplemento(endereco.getComplemento())
                .withEstado(endereco.getEstado())
                .withLogradouro(endereco.getLogradouro())
                .withNumero(endereco.getNumero())
                .build();
    }

}
