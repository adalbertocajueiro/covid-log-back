package br.edu.ufcg.covidlog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.edu.ufcg.covidlog.enums.Role;

@Document(collection = "users")
public class User {
	private Role role;
	@Id
	private String email;
	private String telefone;
	
	public User(String email, String telefone) {
		this.email = email;
		this.telefone = telefone;
		if (email != null) {
			if (email.equals("marcelo.vitorino@ccc.ufcg.edu.br")) {
				this.role = Role.ADMIN;
			} 
		} else {
			this.role = Role.DONOR;
		}
	}
	
	public User() {

	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
