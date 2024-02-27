package com.bac.itformation.controller;

import com.bac.itformation.dto.AdresseDTO;
import com.bac.itformation.model.Adresse;
import com.bac.itformation.service.serviceImpl.AdresseServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adresses")
@CrossOrigin
public class  AdresseController {

    private final AdresseServiceImpl adresseServiceImpl;

    public AdresseController(AdresseServiceImpl adresseServiceImpl) {
        this.adresseServiceImpl = adresseServiceImpl;
    }

    @GetMapping("/all")
    public List<Adresse> findAll() {
        return adresseServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public Adresse findById(@PathVariable Long id) {
        return adresseServiceImpl.findById(id);
    }

    @PostMapping("/add")
    public void save(@RequestBody AdresseDTO adresseDto) {
        adresseServiceImpl.addAdresse(adresseDto);
//        return adresseServiceImpl.save(adresse);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        adresseServiceImpl.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        adresseServiceImpl.deleteById(id);
    }

    @PatchMapping("/update")
    public Adresse update(@RequestBody Adresse adresse) {
        return adresseServiceImpl.update(adresse);
    }
}
