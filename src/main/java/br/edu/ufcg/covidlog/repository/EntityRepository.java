package br.edu.ufcg.covidlog.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufcg.covidlog.model.Entity;

@Repository
public abstract interface EntityRepository extends MongoRepository<Entity, String> {
	Optional<Entity> findById(String id);
	//findByEntityName
}
