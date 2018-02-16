package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.ClientRepository;
import com.example.demo.dao.CompteRepository;
import com.example.demo.dao.OperationRepository;
import com.example.demo.entities.Client;
import com.example.demo.entities.Compte;
import com.example.demo.entities.CompteCourant;
import com.example.demo.entities.CompteEpargne;
import com.example.demo.entities.Retrait;
import com.example.demo.entities.Versement;
import com.example.demo.metier.IBanqueMetier;

@SpringBootApplication
public class VotreBanqueApplication implements CommandLineRunner {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanqueMetier banqueMetier;
	public static void main(String[] args) {
	SpringApplication.run(VotreBanqueApplication.class, args);

	}

	@Override
	public void run(String... arg0) throws Exception {
	Client c1=clientRepository.save(new Client("Malick", "malick@gmail.com"));
	Client c2=clientRepository.save(new Client("Hassane", "hassane@gmail.com"));
	
	Compte cp1=compteRepository.save(new CompteCourant("c1", new Date(), 90000, c1, 6000));
	Compte cp2=compteRepository.save(new CompteEpargne("c2", new Date(), 6000, c1, 5.5 ));
	
	operationRepository.save(new Versement(new Date(), 9000, cp1));
	operationRepository.save(new Versement(new Date(), 6000, cp1));
	operationRepository.save(new Versement(new Date(), 2300, cp1));
	operationRepository.save(new Retrait(new Date(), 9000, cp1));
	
	
	operationRepository.save(new Versement(new Date(), 2300, cp2));
	operationRepository.save(new Versement(new Date(), 400, cp2));
	operationRepository.save(new Versement(new Date(), 2300, cp2));
	operationRepository.save(new Retrait(new Date(), 3000, cp2));
	
	banqueMetier.verser("c1", 111111);
		
	}
}
