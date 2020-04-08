package br.edu.ufcg.covidlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CovidLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidLogApplication.class, args);
	}
	
	@GetMapping("/")
	public String root() {
		return String.format("Hello!!!");
	}

}
