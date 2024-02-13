package com.bac.itformation.service;

import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.Compte;
import com.bac.itformation.repository.CompteRepository;
import com.bac.itformation.repository.CompteRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService {

    private final CompteRepository compteRepository;

    public CompteService(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    public List<Compte> findAll() {
        return compteRepository.findAll();
    }

    public Compte findById(Long id) {
        return compteRepository.findById(id).orElseThrow( () -> new NotFoundException("Compte inconnue !"));
    }

    public Compte findByCompte(String identifiant, String motDePasse){
        System.out.println("===========");
        System.out.println(identifiant + " " + motDePasse);
        Compte tmpCompte = compteRepository.findByMotDePasseAndIdentifiant(motDePasse,identifiant);
        System.out.println(tmpCompte);
        System.out.println("===========");
        return tmpCompte;
    }

    public Compte save(Compte compte) { return compteRepository.save(compte);}


    public Compte update(Compte compte) {
        return compteRepository.save(compte);
    }

    public void deleteById(Long id) {
        compteRepository.deleteById(id);
    }

    public void deleteAll() {
        compteRepository.deleteAll();
    }
}
