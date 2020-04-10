package br.edu.ufcg.covidlog.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufcg.covidlog.model.Need;

@Repository
public abstract interface NeedRepository extends MongoRepository<Need, String> {
	Optional<Need> findById(String id);
	//findByNeedStatus (eq)
	//findByNeedDescription (eq)
	//findByKindOfNeed (eq)
	//findByDate (gt && lt)
	
	//findByEntityID
	//findByEntityIDNeedStatus (eq)
	//findByEntityIDNeedDescription (eq)
	//findByEntityIDKindOfNeed (eq)
	//findByEntityIDDate (gt && lt)
}
