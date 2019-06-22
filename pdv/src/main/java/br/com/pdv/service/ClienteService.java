package br.com.pdv.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pdv.adapter.ClienteAdapter;
import br.com.pdv.domain.Cliente;
import br.com.pdv.domain.dto.ClienteRequestDTO;
import br.com.pdv.domain.dto.ClienteResponseDTO;
import br.com.pdv.repository.ClienteRepository;
import br.com.pdv.service.exception.BusinessException;
import br.com.pdv.service.validator.ClienteValidator;

@Service
public class ClienteService {

    private static final Logger LOG = LogManager.getLogger(ClienteService.class);
    
    @Autowired
    private ClienteValidator clienteValidator;
    @Autowired
    private ClienteRepository clienteRepository;

    public void salvar(ClienteRequestDTO request) {
        LOG.debug("Iniciando sequencia para salvar novo cliente...");
        clienteValidator.validate(request);
        ClienteAdapter adapter = new ClienteAdapter();
        Cliente cliente = adapter.requestToEntity(request);
        clienteRepository.save(cliente);
        LOG.debug("Cliente salvo com sucesso.");
    }

    public List<ClienteResponseDTO> buscarTodos() {
        LOG.debug("Iniciando sequencia para buscar todos os clientes...");
        List<Cliente> clientes = clienteRepository.findAll();
        ClienteAdapter adapter = new ClienteAdapter();
        LOG.debug("Retornando {} clientes.", clientes.size());
        return adapter.entityToResponse(clientes);
    }

    public void alterar(String id, ClienteRequestDTO request) {
        LOG.debug("Iniciando sequencia para alterar cliente...");
        Cliente cliente = buscarPorId(id);
        ClienteAdapter adapter = new ClienteAdapter();
        adapter.requestUpdateToEntity(cliente, request);
        clienteRepository.save(cliente);
        LOG.debug("Cliente alterado com sucesso.");
    }

    public void excluir(String id) {
        LOG.debug("Iniciando sequencia para excluir cliente...");
        buscarPorId(id);
        clienteRepository.deleteById(id);
        LOG.debug("Cliente excluido com sucesso.");
    }
    
    private Cliente buscarPorId(String id) {
        LOG.debug("Buscando cliente pelo id {}", id);
        return clienteRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Cliente nao localizado pelo id: " + id));
    }

}
