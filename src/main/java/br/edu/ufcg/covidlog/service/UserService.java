package br.edu.ufcg.covidlog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.covidlog.exception.RegisterNotFoundException;
import br.edu.ufcg.covidlog.model.User;
import br.edu.ufcg.covidlog.repository.UserRepository;

@Service
public class UserService {
	
	private final String errorMessage = "The user is not registered!";

	@Autowired
	private UserRepository userRepository;

	public User save(User user) {
		userRepository.save(user);
		return user;
	}
	

	public User delete(String email) {
		Optional<User> optUser = userRepository.findById(email);

		if (!optUser.isPresent()) {
			throw new RegisterNotFoundException(errorMessage);
		}

		User user = optUser.get();
		userRepository.delete(user);

		return user;
	}

	public User update(User user, String email) {
		Optional<User> optUser = userRepository.findById(email);

		if (!optUser.isPresent()) {
			throw new RegisterNotFoundException(errorMessage);
		}

		User newUser = optUser.get();
		newUser.setEmail(user.getEmail());
		newUser.setTelefone(user.getTelefone());
		newUser.setRole(user.getRole());
		userRepository.save(newUser);

		return newUser;
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User getById(String email) {
		Optional<User> optUser = userRepository.findById(email);

		if (!optUser.isPresent()) {
			throw new RegisterNotFoundException(errorMessage);
		}

		return optUser.get();
	}

}
