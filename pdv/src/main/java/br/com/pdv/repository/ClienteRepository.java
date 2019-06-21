package br.com.pdv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.pdv.domain.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
