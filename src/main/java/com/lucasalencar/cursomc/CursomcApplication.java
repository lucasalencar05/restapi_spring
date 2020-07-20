package com.lucasalencar.cursomc;

import com.lucasalencar.cursomc.domain.Category;
import com.lucasalencar.cursomc.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null,"Informática");
		Category cat2 = new Category(null,"Escritório");

		categoryRepository.saveAll(Arrays.asList(cat1,cat2));

	}
}
