package br.edu.ufcg.covidlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.covidlog.model.User;
import br.edu.ufcg.covidlog.service.UserService;


@Controller
@RestController
@RequestMapping(value = "/")
@CrossOrigin(origins = "+")
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public ResponseEntity<User> update(@RequestAttribute(name="user") User oldUsuario, @RequestBody User novoUsuario) {
		User updatedUser = userService.update(new User(novoUsuario.getEmail(),novoUsuario.getTelefone()), oldUsuario.getEmail());
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public User getActualUser(@RequestAttribute(name="user") User user) {
		return user;
	}
}
