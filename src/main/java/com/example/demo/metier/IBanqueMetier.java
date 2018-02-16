package com.example.demo.metier;

import org.springframework.data.domain.Page;

import com.example.demo.entities.Compte;
import com.example.demo.entities.Operation;

public interface IBanqueMetier {

	public Compte consulterCompte(String codeCpte);
	public void verser(String codeCpte, double montant);
	public void retirer(String codeCpte, double montant);
	public void virement(String codeCpte1, String codeCpte2, double montant);
	
	public Page<Operation> listOperation(String codeCpte, int page, int size);
	
	
	
	
}
