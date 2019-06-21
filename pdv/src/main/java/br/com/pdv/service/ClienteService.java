package br.com.pdv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pdv.adapter.ClienteAdapter;
import br.com.pdv.domain.Cliente;
import br.com.pdv.domain.dto.ClienteRequestDTO;
import br.com.pdv.repository.ClienteRepository;
import br.com.pdv.service.validator.ClienteValidator;

@Service
public class ClienteService {

    @Autowired
    private ClienteValidator clienteValidator;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteAdapter clienteAdapter;

    public void salvar(ClienteRequestDTO request) {
        clienteValidator.validate(request);
        Cliente cliente = clienteAdapter.requestToEntity(request);
        clienteRepository.save(cliente);
    }
    
    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }

}
