package br.com.pdv.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pdv.domain.dto.ClienteRequestDTO;
import br.com.pdv.domain.dto.ClienteResponseDTO;
import br.com.pdv.service.ClienteService;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyAuthority('INSERIR')")
    @PostMapping("/v1/clientes")
    public void salvar(@RequestBody @Valid ClienteRequestDTO request) {
        service.salvar(request);
    }

    @PreAuthorize("hasAnyAuthority('ALTERAR')")
    @PutMapping("/v1/clientes/{id}")
    public void alterar(@PathVariable String id, @RequestBody @Valid ClienteRequestDTO request) {
        service.alterar(id, request);
    }

    @PreAuthorize("hasAnyAuthority('CONSULTAR')")
    @GetMapping("/v1/clientes")
    public List<ClienteResponseDTO> buscarTodos() {
        return service.buscarTodos();
    }
    
    @PreAuthorize("hasAnyAuthority('REMOVER')")
    @DeleteMapping("/v1/clientes/{id}")
    public void excluir(@PathVariable String id) {
        service.excluir(id);
    }
}
