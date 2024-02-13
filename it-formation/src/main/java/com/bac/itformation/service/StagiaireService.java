package com.bac.itformation.service;

import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.Stagiaire;
import com.bac.itformation.repository.StagiaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StagiaireService {

    private final StagiaireRepository stagiaireRepository;

    public StagiaireService(StagiaireRepository stagiaireRepository) {
        this.stagiaireRepository = stagiaireRepository;
    }

    public List<Stagiaire> findAll() {
        return stagiaireRepository.findAll();
    }

    public Stagiaire findById(Long id) {
        return stagiaireRepository.findById(id).orElseThrow( () -> new NotFoundException("Stagiaire inconnue !"));
    }

    public Stagiaire save(Stagiaire stagiaire) { return stagiaireRepository.save(stagiaire);}


    public Stagiaire update(Stagiaire stagiaire) {
        return stagiaireRepository.save(stagiaire);
    }

    public void deleteById(Long id) {
        stagiaireRepository.deleteById(id);
    }

    public void deleteAll() {
        stagiaireRepository.deleteAll();
    }
}
