package br.com.pdv.adapter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.pdv.domain.Cliente;
import br.com.pdv.domain.Endereco;
import br.com.pdv.domain.Sexo;
import br.com.pdv.domain.dto.ClienteRequestDTO;
import br.com.pdv.domain.dto.ClienteResponseDTO;
import br.com.pdv.domain.dto.EnderecoDTO;
import br.com.pdv.utils.LocalDateUtils;

public class ClienteAdapter implements Adapter<Cliente, ClienteRequestDTO, ClienteResponseDTO> {
    
    private static final Logger LOG = LogManager.getLogger(ClienteAdapter.class);
    
    @Override
    public List<ClienteResponseDTO> entityToResponse(List<Cliente> entities) {
        LOG.debug("Iniciando entityToResponse com lista de {} clientes...", entities.size());
        List<ClienteResponseDTO> dtos = new ArrayList<>();

        for (Cliente cliente : entities) {
            ClienteResponseDTO clienteResponseDTO = clienteToClienteResponseDTO(cliente);
            dtos.add(clienteResponseDTO);
        }
        LOG.debug("entityToResponse concluido.");
        return dtos;
    }

    @Override
    public Cliente requestToEntity(ClienteRequestDTO request) {
        LOG.debug("Iniciando requestToEntity com request {}", request);
        return new Cliente.ClienteBuilder()
                .withCpf(request.getCpf())
                .withDataCadastro(LocalDateUtils.toLocalDateTimeComTimeZone(LocalDateTime.now()))
                .withNome(request.getNome())
                .withSexo(Sexo.valueOf(request.getSexo()))
                .withEndereco(getEndereco(request))
                .build();
    }
    
    @Override
    public ClienteResponseDTO entityToResponse(Cliente entity) {
        return clienteToClienteResponseDTO(entity);
    }
    
    public Cliente requestUpdateToEntity(Cliente cliente, ClienteRequestDTO request) {
        LOG.debug("Iniciando requestUpdateToEntity com cliente {} e request {}", cliente, request);
        return new Cliente.ClienteBuilder()
                .forUpdate(cliente)
                .withCpf(request.getCpf())
                .withNome(request.getNome())
                .withSexo(Sexo.valueOf(request.getSexo()))
                .withEndereco(getEndereco(request))
                .withDataAlteracao(LocalDateUtils.toLocalDateTimeComTimeZone(LocalDateTime.now()))
                .build();
    }
    
    private ClienteResponseDTO clienteToClienteResponseDTO(Cliente cliente) {
        LOG.debug("Iniciando clienteToClienteResponseDTO com cliente {}", cliente);
        return new ClienteResponseDTO.ClienteResponseDTOBuilder()
                .withCpf(cliente.getCpf())
                .withDataCadastro(LocalDateUtils.formatarLocalDateTime(cliente.getDataCadastro()))
                .withDataAlteracao(LocalDateUtils.formatarLocalDateTime(cliente.getDataAlteracao()))
                .withId(cliente.getId())
                .withNome(cliente.getNome())
                .withSexo(String.valueOf(cliente.getSexo()))
                .withEndereco(getEnderecoDTO(cliente))
                .build();
    }

    private EnderecoDTO getEnderecoDTO(Cliente cliente) {
        EnderecoAdapter enderecoAdapter = new EnderecoAdapter();
        return enderecoAdapter.entityToResponse(cliente.getEndereco());
    }
    
    private Endereco getEndereco(ClienteRequestDTO request) {
        EnderecoAdapter enderecoAdapter = new EnderecoAdapter();
        return enderecoAdapter.requestToEntity(request);
    }
}
