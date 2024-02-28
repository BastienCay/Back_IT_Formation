package com.bac.itformation.controller;

import com.bac.itformation.dto.SessionFormationDTO;
import com.bac.itformation.model.SessionFormation;
import com.bac.itformation.service.serviceImpl.SessionFormationServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/sessions-formations")
@CrossOrigin(origins = "http://localhost:4200")
public class SessionFormationController {

    private final SessionFormationServiceImpl sessionFormationServiceImpl;

    public SessionFormationController(SessionFormationServiceImpl sessionFormationServiceImpl) {
        this.sessionFormationServiceImpl = sessionFormationServiceImpl;
    }

    @GetMapping("/all")
    public List<SessionFormation> findAll() {
        return sessionFormationServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public SessionFormation findById(@PathVariable Long id) {
        return sessionFormationServiceImpl.findById(id);
    }

    @PostMapping(value = "/add")
    public SessionFormation addSessionFormation(@RequestBody SessionFormationDTO sessionFormationDto) {
        return sessionFormationServiceImpl.addSessionFormation(sessionFormationDto);
    }
    @PostMapping("/inscription-stagiaire/{idSession}")
    public SessionFormation addStagiaire(@PathVariable Long idSession, @RequestParam String nom) {
        Objects.requireNonNull(idSession, "L'id de Session ne peut pas être null");

        return sessionFormationServiceImpl.addStagiaire(idSession, nom);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        sessionFormationServiceImpl.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        sessionFormationServiceImpl.deleteById(id);
    }

    @PatchMapping("/update")
    public SessionFormation update(@RequestBody SessionFormation sessionFormation) {
        return sessionFormationServiceImpl.update(sessionFormation);
    }
}
