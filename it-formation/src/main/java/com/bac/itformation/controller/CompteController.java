package com.bac.itformation.controller;

import com.bac.itformation.model.Compte;
import com.bac.itformation.service.CompteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comptes")
@CrossOrigin
public class CompteController {
    private final CompteService compteService;

    public CompteController(CompteService compteService) {
        this.compteService = compteService;
    }

    @GetMapping("/all")
    public List<Compte> findAll() {
        return compteService.findAll();
    }

    @GetMapping("/{id}")
    public Compte findById(@PathVariable Long id) {
        return compteService.findById(id);
    }

    @GetMapping("/find")
    public Compte findByCompte(@RequestParam String identifiant,@RequestParam String motDePasse){
        return compteService.findByCompte(identifiant,motDePasse);}

    @PostMapping("/add")
    public Compte save(@RequestBody Compte compte) {
        return compteService.save(compte);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        compteService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        compteService.deleteById(id);
    }

    @PatchMapping("/update")
    public Compte update(@RequestBody Compte compte) {
        return compteService.update(compte);
    }


}
