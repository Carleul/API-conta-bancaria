package com.example.crud_user;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.crud_user.model.ContaBancaria;
import com.example.crud_user.repository.ContaBancariaRepository;
import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
public class CrudUserApplication {

	@Autowired
	private static HikariDataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(CrudUserApplication.class, args);
		System.out.println("http://localhost:8080");
		dataSource = new HikariDataSource();
		try {
			dataSource.setJdbcUrl("jdbc:h2:mem:testdb");
			dataSource.setUsername("sa");
			dataSource.setPassword("");
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setAutoCommit(false);
			Connection conn = dataSource.getConnection();
			System.out.println("Auto"+conn.getAutoCommit());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Bean
	public CommandLineRunner cadastrarContas(ContaBancariaRepository repo) {
		return args -> {
			repo.save(new ContaBancaria("0001", "Felipe", true));
			repo.save(new ContaBancaria("0002", "João", true));
			repo.save(new ContaBancaria("0003", "Lafayette", true));
			repo.save(new ContaBancaria("0004", "Isabela", true));
			repo.save(new ContaBancaria("0005", "Carlos", true));
			repo.save(new ContaBancaria("0006", "Lucas", false));
			repo.save(new ContaBancaria("0007", "Eduardo", true));
			repo.save(new ContaBancaria("0008", "Arthur", true));
			repo.save(new ContaBancaria("0009", "Marcelo", true));
			repo.save(new ContaBancaria("0010", "Marcos", true));
		};
}

	}
