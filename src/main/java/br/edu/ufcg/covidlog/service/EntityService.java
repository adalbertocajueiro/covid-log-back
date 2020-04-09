package br.edu.ufcg.covidlog.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.ufcg.covidlog.exception.PermissionDeniedException;
import br.edu.ufcg.covidlog.exception.RegisterNotFoundException;
import br.edu.ufcg.covidlog.model.Entity;
import br.edu.ufcg.covidlog.repository.EntityRepository;

@Service
public class EntityService {
	
	private final String errorMessage = "The entity is not registered";
	
	@Autowired
	private EntityRepository entityRepository;

	public Entity save(Entity entity) throws IOException {
		entityRepository.save(entity);
		return entity;
	}
	 
	public Entity delete(String id) {
		Optional<Entity> optEntity = entityRepository.findById(id);

		if (!optEntity.isPresent()) {
			throw new RegisterNotFoundException(errorMessage);
		}

		Entity entity = optEntity.get();

		entityRepository.delete(entity);
		return entity;
	}
	
	public Entity update(Entity entity, String id) throws IOException {

		Optional<Entity> optEntity = entityRepository.findById(id);

		if (!optEntity.isPresent()) {
			throw new RegisterNotFoundException(errorMessage);
		}

		Entity newEntity = optEntity.get();
		
		if (!entity.getName().equals(newEntity.getName())) {
			throw new PermissionDeniedException("The entity ownering is from another user");
		}


        entity.setId(id);

		entityRepository.save(entity);

		return entity;
	}
	
	public Page<Entity> getAll(int page, int size) {
	    Pageable pageable = PageRequest.of(page, size);
	    Page<Entity> pag = entityRepository.findAll(pageable);
	    
		return pag;
	}
	
	public Entity getById(String id) {
		Optional<Entity> optEntity = entityRepository.findById(id);

		if (!optEntity.isPresent()) {
			throw new RegisterNotFoundException(errorMessage);
		}

		return optEntity.get();
	}
}