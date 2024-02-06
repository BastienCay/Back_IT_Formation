package com.bac.itformation.service;

import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.Evaluation;
import com.bac.itformation.repository.EvaluationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;

    public EvaluationService(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    public List<Evaluation> findAll() {
        return evaluationRepository.findAll();
    }

    public Evaluation findById(Long id) {
        return evaluationRepository.findById(id).orElseThrow( () -> new NotFoundException("Evaluation inconnue !"));
    }

    public Evaluation save(Evaluation evaluation) { return evaluationRepository.save(evaluation);}


    public Evaluation update(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    public void deleteById(Long id) {
        evaluationRepository.deleteById(id);
    }

    public void deleteAll() {
        evaluationRepository.deleteAll();
    }
}
