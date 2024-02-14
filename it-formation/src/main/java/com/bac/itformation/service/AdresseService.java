package com.bac.itformation.service;

import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.Adresse;
import com.bac.itformation.repository.AdresseRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresseService {

    private final AdresseRepository adresseRepository;
    private final JdbcTemplate jdbcTemplate;

    public AdresseService(AdresseRepository adresseRepository, JdbcTemplate jdbcTemplate) {
        this.adresseRepository = adresseRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Adresse> findAll() {
        return adresseRepository.findAll();
    }

    public Adresse findById(Long id) {
        return adresseRepository.findById(id).orElseThrow( () -> new NotFoundException("Adresse inconnue !"));
    }

    public Adresse save(Adresse adresse) {
        System.out.println(adresse);
        return adresseRepository.save(adresse);
    }


    public Adresse update(Adresse adresse) {
        return adresseRepository.save(adresse);
    }

    public void deleteById(Long id) {
        adresseRepository.deleteById(id);
    }

    public void deleteAll() {
        adresseRepository.deleteAll();
    }
}
