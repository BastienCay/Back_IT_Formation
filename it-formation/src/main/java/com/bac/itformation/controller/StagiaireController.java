package com.bac.itformation.controller;

import com.bac.itformation.model.Stagiaire;
import com.bac.itformation.service.StagiaireService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stagiaires")
@CrossOrigin
public class StagiaireController {

    private final StagiaireService stagiaireService;

    public StagiaireController(StagiaireService stagiaireService) {
        this.stagiaireService = stagiaireService;
    }

    @GetMapping("/all")
    public List<Stagiaire> findAll() {
        return stagiaireService.findAll();
    }

    @GetMapping("/{id}")
    public Stagiaire findById(@PathVariable Long id) {
        return stagiaireService.findById(id);
    }

    @PostMapping("/add")
    public Stagiaire save(@RequestBody Stagiaire stagiaire) {
        return stagiaireService.save(stagiaire);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        stagiaireService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        stagiaireService.deleteById(id);
    }

    @PatchMapping("/update")
    public Stagiaire update(@RequestBody Stagiaire stagiaire) {
        return stagiaireService.update(stagiaire);
    }
}
