package com.bac.itformation.service;

import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.Utilisateur;
import com.bac.itformation.repository.UtilisateurRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final JdbcTemplate jdbcTemplate;

    public UtilisateurService(UtilisateurRepository utilisateurRepository, JdbcTemplate jdbcTemplate) {
        this.utilisateurRepository = utilisateurRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur findById(Long id) {
        return utilisateurRepository.findById(id).orElseThrow( () -> new NotFoundException("User inconnue !"));
    }

    public Utilisateur save(Utilisateur utilisateur) { return utilisateurRepository.save(utilisateur);}


    public Utilisateur update(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public void deleteById(Long id) {
        utilisateurRepository.deleteById(id);
    }

    public void deleteAll() {
        utilisateurRepository.deleteAll();
    }

}
