package br.com.pdv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.pdv.security.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}
