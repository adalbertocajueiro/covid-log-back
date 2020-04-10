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

import br.edu.ufcg.covidlog.model.Need;
import br.edu.ufcg.covidlog.service.NeedService;

@Controller
@RestController
@RequestMapping(value = "/")
@CrossOrigin(origins = "+")
public class NeedController {
	
	@Autowired
	NeedService needService;
	
	@RequestMapping(value = "/need", method = RequestMethod.POST)
	public Need save(@RequestBody Need entity) throws IOException {
		return needService.save(entity);
	}
	
	@RequestMapping(value = "/need/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Need> delete(@PathVariable("id") String id) {
		Need entity = needService.delete(id);
		return new ResponseEntity<Need>(entity, HttpStatus.OK);
	}

	@RequestMapping(value = "/need/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Need> update(@PathVariable("id") String id, @RequestBody Need entity) throws IOException {
		Need updatedEntity = needService.update(entity, id);
		return new ResponseEntity<Need>(updatedEntity, HttpStatus.OK);
	}

	@RequestMapping(value = "/need/{page}/{size}", method = RequestMethod.GET)
	public Page<Need> getAll(@PathVariable("page") int page,@PathVariable("size") int size) {
		return needService.getAll(page,size);
	}

	@RequestMapping(value = "/need/{id}", method = RequestMethod.GET)
	public Need getById(@PathVariable("id") String id) {
		return needService.getById(id);
	}
}
