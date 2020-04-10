package br.edu.ufcg.covidlog.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.edu.ufcg.covidlog.model.Donation;

public abstract interface DonationRepository extends MongoRepository<Donation, String> {
	Optional<Donation> findById(String id);
	
	//findByRangeDate
	//findByKind
	//findByDescription
	
	//findByUSerId
	//findByUSerIdRangeDate
	//findByUSerIdKind
	//findByUSerIdDescription
}
