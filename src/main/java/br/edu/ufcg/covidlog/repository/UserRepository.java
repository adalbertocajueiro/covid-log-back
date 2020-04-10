package br.edu.ufcg.covidlog.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufcg.covidlog.model.User;

@Repository
public abstract interface UserRepository extends MongoRepository<User, String> {
	Optional<User> findById(String id);

}
