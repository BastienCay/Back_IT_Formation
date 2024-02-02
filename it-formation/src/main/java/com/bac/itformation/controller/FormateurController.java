package com.bac.itformation.controller;

import com.bac.itformation.model.Formateur;
import com.bac.itformation.service.FormateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formateurs")
@CrossOrigin
public class FormateurController {

    private final FormateurService formateurService;

    public FormateurController(FormateurService formateurService) {
        this.formateurService = formateurService;
    }

    @GetMapping("/all")
    public List<Formateur> findAll() {
        return formateurService.findAll();
    }

    @GetMapping("/{id}")
    public Formateur findById(@PathVariable Long id) {
        return formateurService.findById(id);
    }

    @PostMapping("/add")
    public Formateur save(@RequestBody Formateur formateur) {
        return formateurService.save(formateur);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        formateurService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        formateurService.deleteById(id);
    }

    @PatchMapping("/update")
    public Formateur update(@RequestBody Formateur formateur) {
        return formateurService.update(formateur);
    }
}
