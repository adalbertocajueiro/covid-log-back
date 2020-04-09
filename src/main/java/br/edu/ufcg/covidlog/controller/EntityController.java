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

import br.edu.ufcg.covidlog.model.Entity;
import br.edu.ufcg.covidlog.service.EntityService;

@Controller
@RestController
@RequestMapping(value = "/")
@CrossOrigin(origins = "+")
public class EntityController {
	
	@Autowired
	EntityService entityService;
	
	@RequestMapping(value = "/entity", method = RequestMethod.POST)
	public Entity save(@RequestBody Entity entity) throws IOException {
		return entityService.save(entity);
	}
	
	@RequestMapping(value = "/entity/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Entity> delete(@PathVariable("id") String id) {
		Entity entity = entityService.delete(id);
		return new ResponseEntity<Entity>(entity, HttpStatus.OK);
	}

	@RequestMapping(value = "/entity/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Entity> update(@PathVariable("id") String id, @RequestBody Entity questao) throws IOException {
		Entity updatedQuestao = entityService.update(questao, id);
		return new ResponseEntity<Entity>(updatedQuestao, HttpStatus.OK);
	}

	@RequestMapping(value = "/entity/{page}/{size}", method = RequestMethod.GET)
	public Page<Entity> getAll(@PathVariable("page") int page,@PathVariable("size") int size) {
		return entityService.getAll(page,size);
	}

	@RequestMapping(value = "/entity/{id}", method = RequestMethod.GET)
	public Entity getById(@PathVariable("id") String id) {
		return entityService.getById(id);
	}

}
