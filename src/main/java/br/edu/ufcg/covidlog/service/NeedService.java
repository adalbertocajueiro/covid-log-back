package br.edu.ufcg.covidlog.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.ufcg.covidlog.exception.RegisterNotFoundException;
import br.edu.ufcg.covidlog.model.Need;
import br.edu.ufcg.covidlog.repository.NeedRepository;

@Service
public class NeedService {
	
	private final String errorMessage = "The need is not registered";
	
	@Autowired
	private NeedRepository needRepository;

	public Need save(Need need) throws IOException {
		needRepository.save(need);
		return need;
	}
	 
	public Need delete(String id) {
		Optional<Need> optNeed = needRepository.findById(id);

		if (!optNeed.isPresent()) {
			throw new RegisterNotFoundException(errorMessage);
		}

		Need need = optNeed.get();

		needRepository.delete(need);
		return need;
	}
	
	public Need update(Need need, String id) throws IOException {

		Optional<Need> optNeed = needRepository.findById(id);

		if (!optNeed.isPresent()) {
			throw new RegisterNotFoundException(errorMessage);
		}

		Need newNeed = optNeed.get();
		newNeed.setKind(need.getKind());
		newNeed.setStatus(need.getStatus());
		newNeed.setEntityId(need.getEntityId());
		newNeed.setDescription(need.getDescription());
		newNeed.setDate(need.getDate());
		needRepository.save(newNeed);

		return newNeed;
	}
	
	public Page<Need> getAll(int page, int size) {
	    Pageable pageable = PageRequest.of(page, size);
	    Page<Need> pag = needRepository.findAll(pageable);
	    
		return pag;
	}
	
	public Need getById(String id) {
		Optional<Need> optNeed = needRepository.findById(id);

		if (!optNeed.isPresent()) {
			throw new RegisterNotFoundException(errorMessage);
		}

		return optNeed.get();
	}
}
