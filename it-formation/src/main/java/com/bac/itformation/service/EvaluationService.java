package com.bac.itformation.service;

import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.EvaluationStagiaire;
import com.bac.itformation.repository.EvaluationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;

    public EvaluationService(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    public List<EvaluationStagiaire> findAll() {
        return evaluationRepository.findAll();
    }

    public EvaluationStagiaire findById(Long id) {
        return evaluationRepository.findById(id).orElseThrow( () -> new NotFoundException("Evaluation inconnue !"));
    }

    public EvaluationStagiaire save(EvaluationStagiaire evaluationStagiaire) { return evaluationRepository.save(evaluationStagiaire);}


    public EvaluationStagiaire update(EvaluationStagiaire evaluationStagiaire) {
        return evaluationRepository.save(evaluationStagiaire);
    }

    public void deleteById(Long id) {
        evaluationRepository.deleteById(id);
    }

    public void deleteAll() {
        evaluationRepository.deleteAll();
    }
}
