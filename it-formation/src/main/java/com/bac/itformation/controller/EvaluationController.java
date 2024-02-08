package com.bac.itformation.controller;

import com.bac.itformation.model.EvaluationStagiaire;
import com.bac.itformation.service.EvaluationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluations")
@CrossOrigin
public class EvaluationController {

    private final EvaluationService evaluationService;

    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @GetMapping("/all")
    public List<EvaluationStagiaire> findAll() {
        return evaluationService.findAll();
    }

    @GetMapping("/{id}")
    public EvaluationStagiaire findById(@PathVariable Long id) {
        return evaluationService.findById(id);
    }

    @PostMapping("/add")
    public EvaluationStagiaire save(@RequestBody EvaluationStagiaire evaluationStagiaire) {
        return evaluationService.save(evaluationStagiaire);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        evaluationService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        evaluationService.deleteById(id);
    }

    @PatchMapping("/update")
    public EvaluationStagiaire update(@RequestBody EvaluationStagiaire evaluationStagiaire) {
        return evaluationService.update(evaluationStagiaire);
    }
}
