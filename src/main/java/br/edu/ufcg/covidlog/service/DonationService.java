package br.edu.ufcg.covidlog.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.ufcg.covidlog.exception.RegisterNotFoundException;
import br.edu.ufcg.covidlog.model.Donation;
import br.edu.ufcg.covidlog.repository.DonationRepository;

@Service
public class DonationService {
	
	private final String errorMessage = "The donation is not registered";
	
	@Autowired
	private DonationRepository donationRepository;

	public Donation save(Donation donation) throws IOException {
		donationRepository.save(donation);
		return donation;
	}
	 
	public Donation delete(String id) {
		Optional<Donation> optDonation = donationRepository.findById(id);

		if (!optDonation.isPresent()) {
			throw new RegisterNotFoundException(errorMessage);
		}

		Donation donation = optDonation.get();

		donationRepository.delete(donation);
		return donation;
	}
	
	public Donation update(Donation donation, String id) throws IOException {

		Optional<Donation> optDonation = donationRepository.findById(id);

		if (!optDonation.isPresent()) {
			throw new RegisterNotFoundException(errorMessage);
		}

		Donation newDonation = optDonation.get();
		newDonation.setKind(donation.getKind());
		newDonation.setRequiresTransport(donation.isRequiresTransport());
		newDonation.setTargetNeed(donation.getTargetNeed());
		newDonation.setUserId(donation.getUserId());
		newDonation.setDescription(donation.getDescription());
		newDonation.setDate(donation.getDate());
		
		donationRepository.save(newDonation);

		return newDonation;
	}
	
	public Page<Donation> getAll(int page, int size) {
	    Pageable pageable = PageRequest.of(page, size);
	    Page<Donation> pag = donationRepository.findAll(pageable);
	    
		return pag;
	}
	
	public Donation getById(String id) {
		Optional<Donation> optDonation = donationRepository.findById(id);

		if (!optDonation.isPresent()) {
			throw new RegisterNotFoundException(errorMessage);
		}

		return optDonation.get();
	}
}
