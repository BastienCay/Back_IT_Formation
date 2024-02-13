package com.bac.itformation.controller;

import com.bac.itformation.dto.FormationDTO;
import com.bac.itformation.model.Formation;
import com.bac.itformation.service.FormationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formations")
@CrossOrigin
public class FormationController {

    private final FormationService formationService;

    public FormationController(FormationService formationService) {
        this.formationService = formationService;
    }

    @GetMapping("/all")
    public List<Formation> findAll() {
        return formationService.findAll();
    }

    @GetMapping("/{id}")
    public Formation findById(@PathVariable Long id) {
        return formationService.findById(id);
    }

    @PostMapping("/add")
    public void addFormation (@RequestBody FormationDTO formationDto) {

        formationService.addFormation(formationDto);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        formationService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        formationService.deleteById(id);
    }

    @PatchMapping("/update")
    public Formation update(@RequestBody Formation formation) {
        return formationService.update(formation);
    }
}
