package br.edu.ufcg.covidlog.exception;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException() {
        super("Token inválido ou expirado!");
    }
}
