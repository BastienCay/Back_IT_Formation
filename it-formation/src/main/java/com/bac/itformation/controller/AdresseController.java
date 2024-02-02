package com.bac.itformation.controller;

import com.bac.itformation.model.Adresse;
import com.bac.itformation.service.AdresseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adresses")
@CrossOrigin
public class AdresseController {

    private final AdresseService adresseService;

    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @GetMapping("/all")
    public List<Adresse> findAll() {
        return adresseService.findAll();
    }

    @GetMapping("/{id}")
    public Adresse findById(@PathVariable Long id) {
        return adresseService.findById(id);
    }

    @PostMapping("/add")
    public Adresse save(@RequestBody Adresse adresse) {
        return adresseService.save(adresse);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        adresseService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        adresseService.deleteById(id);
    }

    @PatchMapping("/update")
    public Adresse update(@RequestBody Adresse adresse) {
        return adresseService.update(adresse);
    }
}
