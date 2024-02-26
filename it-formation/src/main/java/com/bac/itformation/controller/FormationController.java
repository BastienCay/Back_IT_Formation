package com.bac.itformation.controller;

import com.bac.itformation.model.Formation;
import com.bac.itformation.service.serviceImpl.FormationServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formations")
@CrossOrigin
public class FormationController {

    private final FormationServiceImpl formationServiceImpl;

    public FormationController(FormationServiceImpl formationServiceImpl) {
        this.formationServiceImpl = formationServiceImpl;
    }

    @GetMapping("/all")
    public List<Formation> findAll() {
        return formationServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public Formation findById(@PathVariable Long id) {
        return formationServiceImpl.findById(id);
    }

    @PostMapping("/add")
    public void addFormation (@RequestBody Formation formation) {

     //   formationService.addFormation(formationDto);
        formationServiceImpl.save(formation);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        formationServiceImpl.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        formationServiceImpl.deleteById(id);
    }

    @PatchMapping("/update")
    public Formation update(@RequestBody Formation formation) {
        return formationServiceImpl.update(formation);
    }
}
