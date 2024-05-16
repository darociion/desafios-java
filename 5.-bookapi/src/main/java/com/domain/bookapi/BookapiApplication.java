package com.domain.bookapi;

import com.domain.bookapi.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Primer challenge Spring");
		Main principal = new Main();
		principal.mostrarMenu();
	}
}
