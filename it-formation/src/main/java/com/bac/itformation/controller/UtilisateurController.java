package com.bac.itformation.controller;

import com.bac.itformation.model.Utilisateur;
import com.bac.itformation.service.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
@CrossOrigin
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/all")
    public List<Utilisateur> findAll() {
        return utilisateurService.findAll();
    }

    @GetMapping("/{id}")
    public Utilisateur findById(@PathVariable Long id) {
        return utilisateurService.findById(id);
    }

    @PostMapping("/add")
    public Utilisateur save(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.save(utilisateur);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        utilisateurService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        utilisateurService.deleteById(id);
    }

    @PatchMapping("/update")
    public Utilisateur update(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.update(utilisateur);
    }

}
