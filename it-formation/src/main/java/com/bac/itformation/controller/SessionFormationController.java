package com.bac.itformation.controller;

import com.bac.itformation.model.SessionFormation;
import com.bac.itformation.service.SessionFormationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions-formations")
@CrossOrigin
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

    @PostMapping("/add")
    public SessionFormation save(@RequestBody SessionFormation sessionFormation) {
        return sessionFormationService.save(sessionFormation);
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
