package com.bac.itformation.controller;

import com.bac.itformation.dto.FormateurDTO;
import com.bac.itformation.model.Formateur;
import com.bac.itformation.service.serviceImpl.FormateurServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formateurs")
@CrossOrigin
public class FormateurController {

    private final FormateurServiceImpl formateurServiceImpl;

    public FormateurController(FormateurServiceImpl formateurServiceImpl) {
        this.formateurServiceImpl = formateurServiceImpl;
    }

    @GetMapping("/all")
    public List<FormateurDTO> findAll() {
        return formateurServiceImpl.getAllFormateurs();
    }

    @GetMapping("/{id}")
    public Formateur findById(@PathVariable Long id) {
        return formateurServiceImpl.findById(id);
    }

    @PostMapping("/add")
    public Formateur save(@RequestBody Formateur formateur) {
        return formateurServiceImpl.save(formateur);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        formateurServiceImpl.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        formateurServiceImpl.deleteById(id);
    }

    @PatchMapping("/update")
    public Formateur update(@RequestBody Formateur formateur) {
        return formateurServiceImpl.update(formateur);
    }
}
