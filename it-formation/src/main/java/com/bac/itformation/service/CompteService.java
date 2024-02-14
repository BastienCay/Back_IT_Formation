package com.bac.itformation.service;

import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.Compte;
import com.bac.itformation.repository.CompteRepository;
import com.bac.itformation.repository.CompteRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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

    public Compte findByCompte(Compte compte){
        return compteRepository.findByMotDePasseAndIdentifiant(compte.getMotDePasse(),compte.getIdentifiant());
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
