package br.com.pdv.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.pdv.domain.Configuracao;

@Repository
public interface ConfiguracaoRepository extends MongoRepository<Configuracao, String> {

    Optional<Configuracao> findByChave(String chave);

}
