package com.bac.itformation.controller;

import com.bac.itformation.model.SessionFormation;
import com.bac.itformation.model.Stagiaire;
import com.bac.itformation.service.SessionFormationService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/sessions-formations")
@CrossOrigin(origins = "http://localhost:4200")
public class SessionFormationController {

    private final SessionFormationService sessionFormationService;

    public SessionFormationController(SessionFormationService sessionFormationService) {
        this.sessionFormationService = sessionFormationService;
    }

    @GetMapping("/all")
    public List<SessionFormation> findAll() {
        return sessionFormationService.findAll();
    }

    @GetMapping("/{id}")
    public SessionFormation findById(@PathVariable Long id) {
        return sessionFormationService.findById(id);
    }

    @PostMapping(value = "/add")
    public SessionFormation addSessionFormation(@RequestParam String telephone, @RequestBody SessionFormation sessionFormation) {


        return sessionFormationService.addSessionFormation(telephone, sessionFormation);
    }
    @PostMapping("/inscription-stagiaire/{idSession}")
    public SessionFormation addStagiaire(@PathVariable Long idSession, @RequestParam String nom) {
        Objects.requireNonNull(idSession, "L'id de Session ne peut pas être null");

        return sessionFormationService.addStagiaire(idSession, nom);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        sessionFormationService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        sessionFormationService.deleteById(id);
    }

    @PatchMapping("/update")
    public SessionFormation update(@RequestBody SessionFormation sessionFormation) {
        return sessionFormationService.update(sessionFormation);
    }
}
