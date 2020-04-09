package br.edu.ufcg.covidlog.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.edu.ufcg.covidlog.enums.Role;

@Document(collection = "users")
public class User {
	@Id
	@JsonProperty
	private String id;
	private Role role;
	private String email;
	private String telefone;
	private List<Donation> donations;
	
	public User(String email, String telefone, List<Donation> donations) {
		this.email = email;
		this.telefone = telefone;
		if (email.equals("marcelo.vitorino@ccc.ufcg.edu.br")) {
			this.role = Role.ADMIN;
		} else {
			this.role = Role.DONOR;
		}
		this.donations = new ArrayList<Donation>(donations);
	}
	
	public User() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<Donation> getDonations() {
		return donations;
	}

	public void setDonations(List<Donation> donations) {
		this.donations = donations;
	}
}
