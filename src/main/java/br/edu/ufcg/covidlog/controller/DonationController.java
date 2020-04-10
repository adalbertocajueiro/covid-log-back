package br.edu.ufcg.covidlog.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.covidlog.model.Donation;
import br.edu.ufcg.covidlog.service.DonationService;

@Controller
@RestController
@RequestMapping(value = "/")
@CrossOrigin(origins = "+")
public class DonationController {
	
	@Autowired
	DonationService donationService;
	
	@RequestMapping(value = "/donation", method = RequestMethod.POST)
	public Donation save(@RequestBody Donation entity) throws IOException {
		return donationService.save(entity);
	}
	
	@RequestMapping(value = "/donation/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Donation> delete(@PathVariable("id") String id) {
		Donation donation = donationService.delete(id);
		return new ResponseEntity<Donation>(donation, HttpStatus.OK);
	}

	@RequestMapping(value = "/donation/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Donation> update(@PathVariable("id") String id, @RequestBody Donation donation) throws IOException {
		Donation updatedDonation = donationService.update(donation, id);
		return new ResponseEntity<Donation>(updatedDonation, HttpStatus.OK);
	}

	@RequestMapping(value = "/donation/{page}/{size}", method = RequestMethod.GET)
	public Page<Donation> getAll(@PathVariable("page") int page,@PathVariable("size") int size) {
		return donationService.getAll(page,size);
	}

	@RequestMapping(value = "/donation/{id}", method = RequestMethod.GET)
	public Donation getById(@PathVariable("id") String id) {
		return donationService.getById(id);
	}
}
