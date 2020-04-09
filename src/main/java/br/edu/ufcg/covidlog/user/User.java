package br.edu.ufcg.covidlog.user;

enum Role {
	ADMIN,DONOR
}

public class User {
	private long id;
	private Role role;
	private String email;
	private String telefone;
}
