package br.edu.utfpr.alunos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.edu.utfpr.alunos.services.UserService;

@SpringBootApplication
public class ShowBeneficenteSpringAplication {

	@Value("${pagina.quantidade}")
	private int quantidade;
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ShowBeneficenteSpringAplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Quantidade " + quantidade);
			userService.init();
		};
	}
}
