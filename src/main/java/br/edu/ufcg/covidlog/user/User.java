package br.edu.ufcg.covidlog.user;

enum Role {ADMIN,DONOR}
public class User {
	private Role role;
	private String email;
}
