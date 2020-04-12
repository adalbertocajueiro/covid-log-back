package br.edu.ufcg.covidlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import br.edu.ufcg.covidlog.exception.InvalidTokenException;
import br.edu.ufcg.covidlog.exception.UserAlreadyExistException;
import br.edu.ufcg.covidlog.model.User;
import br.edu.ufcg.covidlog.service.UserService;
import br.edu.ufcg.covidlog.util.GoogleIdVerifier;


@Controller
@RestController
@RequestMapping(value = "/")
@CrossOrigin(origins = "+")
public class AuthController {
	
    @Autowired
    UserService userService;

    @RequestMapping(value = "/auth/authenticate", method = RequestMethod.GET)
    public ResponseEntity<String> authenticate() {
        return new ResponseEntity<>("User authenticated", HttpStatus.OK);
    }


    @RequestMapping(value = "/auth/signup", method = RequestMethod.POST)
    public ResponseEntity<String> signup(@RequestBody User user, @RequestHeader("Authorization") String token) {
        if(token == null || !token.startsWith("Bearer ")) {
            throw new InvalidTokenException();
        }
        

        GoogleIdToken.Payload payload = GoogleIdVerifier.getPayload(token.substring(7));

        String email = payload.getEmail();

        try {
            userService.getById(email);
            throw new UserAlreadyExistException();
        } catch (Exception e) {
            userService.save(new User(email, user.getTelefone()));
        }
        return new ResponseEntity<>("User successfully authenticated", HttpStatus.OK);
    }
}
