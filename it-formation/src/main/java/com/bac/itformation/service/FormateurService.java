package com.bac.itformation.service;

import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.Formateur;
import com.bac.itformation.model.Formateur;
import com.bac.itformation.repository.FormateurRepository;
import com.bac.itformation.repository.FormateurRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormateurService {

    private final FormateurRepository formateurRepository;
    private final JdbcTemplate jdbcTemplate;

    public FormateurService(FormateurRepository formateurRepository, JdbcTemplate jdbcTemplate) {
        this.formateurRepository = formateurRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Formateur> findAll() {
        return formateurRepository.findAll();
    }

    public Formateur findById(Long id) {
        return formateurRepository.findById(id).orElseThrow( () -> new NotFoundException("Formateur inconnue !"));
    }

    public Formateur save(Formateur formateur) { return formateurRepository.save(formateur);}


    public Formateur update(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    public void deleteById(Long id) {
        formateurRepository.deleteById(id);
    }

    public void deleteAll() {
        formateurRepository.deleteAll();
    }
}
