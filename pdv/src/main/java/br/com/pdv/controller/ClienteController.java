package br.com.pdv.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pdv.domain.Cliente;
import br.com.pdv.domain.dto.ClienteRequestDTO;
import br.com.pdv.service.ClienteService;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/v1/clientes")
    public void salvar(@RequestBody @Valid ClienteRequestDTO request) {
        service.salvar(request);
    }
    
    @PutMapping("/v1/clientes")
    public void alterar(@RequestBody @Valid ClienteRequestDTO request) {
        service.alterar(request);
    }
    
    @GetMapping("/v1/clientes")
    public List<Cliente> buscarTodos() {
        return service.buscarTodos();
    }
}
