package br.edu.ufcg.covidlog.exception;

public class RegisterNotFoundException extends RuntimeException {
	public RegisterNotFoundException(String message) {
		super(message);
	}
}