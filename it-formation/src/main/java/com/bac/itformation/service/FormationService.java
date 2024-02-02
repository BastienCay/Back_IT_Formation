package com.bac.itformation.service;

import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.Formation;
import com.bac.itformation.repository.FormationRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationService {

    private final FormationRepository formationRepository;
    private final JdbcTemplate jdbcTemplate;

    public FormationService(FormationRepository formationRepository, JdbcTemplate jdbcTemplate) {
        this.formationRepository = formationRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Formation> findAll() {
        return formationRepository.findAll();
    }

    public Formation findById(Long id) {
        return formationRepository.findById(id).orElseThrow( () -> new NotFoundException("Formation inconnue !"));
    }

    public Formation save(Formation formation) { return formationRepository.save(formation);}


    public Formation update(Formation formation) {
        return formationRepository.save(formation);
    }

    public void deleteById(Long id) {
        formationRepository.deleteById(id);
    }

    public void deleteAll() {
        formationRepository.deleteAll();
    }
}
