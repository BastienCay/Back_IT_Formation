package com.bac.itformation.controller;

import com.bac.itformation.model.Evaluation;
import com.bac.itformation.service.EvaluationService;
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
    public List<Evaluation> findAll() {
        return evaluationService.findAll();
    }

    @GetMapping("/{id}")
    public Evaluation findById(@PathVariable Long id) {
        return evaluationService.findById(id);
    }

    @PostMapping("/add")
    public Evaluation save(@RequestBody Evaluation evaluation) {
        return evaluationService.save(evaluation);
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
    public Evaluation update(@RequestBody Evaluation evaluation) {
        return evaluationService.update(evaluation);
    }
}
