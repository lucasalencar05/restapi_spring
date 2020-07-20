package com.lucasalencar.cursomc;

import com.lucasalencar.cursomc.domain.*;
import com.lucasalencar.cursomc.domain.enums.TypeClient;
import com.lucasalencar.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AddressRepository addressRepository;


	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null,"Informática");
		Category cat2 = new Category(null,"Escritório");

		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);

		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().addAll(Arrays.asList(p2));

		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1,cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));

		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));

		State s1 = new State(null, "Minas Gerais");
		State s2 = new State(null, "São Paulo");

		Country c1 = new Country(null, "Uberlândia", s1);
		Country c2 = new Country(null, "São Paulo", s2);
		Country c3 = new Country(null, "Campinas", s2);

		s1.getCountries().addAll(Arrays.asList(c1));
		s2.getCountries().addAll(Arrays.asList(c2,c3));


		stateRepository.saveAll(Arrays.asList(s1,s2));
		countryRepository.saveAll(Arrays.asList(c1,c2,c3));

		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "02015667890", TypeClient.PESSOAFISICA);

		cli1.getPhone().addAll(Arrays.asList("9932345678", "981335445"));

		Address a1 = new Address(null, "Rua Flores", "300", "Casa 20", "Jardim", "38220989", cli1, c1);
		Address a2 = new Address(null, "Avenida Santos", "20", "Sala 02", "Centro", "71220989", cli1, c2);

		cli1.getAddresses().addAll(Arrays.asList(a1, a2));

		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(a1, a2));

	}
}
