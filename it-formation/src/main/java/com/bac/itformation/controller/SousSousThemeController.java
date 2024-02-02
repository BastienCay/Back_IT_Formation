package com.bac.itformation.controller;

import com.bac.itformation.model.SousSousTheme;
import com.bac.itformation.service.SousSousThemeService;
import com.bac.itformation.service.SousSousThemeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sous-sous-themes")
@CrossOrigin
public class SousSousThemeController {

    private final SousSousThemeService sousSousThemeService;

    public SousSousThemeController(SousSousThemeService sousSousThemeService) {
        this.sousSousThemeService = sousSousThemeService;
    }

    @GetMapping("/all")
    public List<SousSousTheme> findAll() {
        return sousSousThemeService.findAll();
    }

    @GetMapping("/{id}")
    public SousSousTheme findById(@PathVariable Long id) {
        return sousSousThemeService.findById(id);
    }

    @PostMapping("/add")
    public SousSousTheme save(@RequestBody SousSousTheme sousSousTheme) {
        return sousSousThemeService.save(sousSousTheme);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        sousSousThemeService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        sousSousThemeService.deleteById(id);
    }

    @PatchMapping("/update")
    public SousSousTheme update(@RequestBody SousSousTheme sousSousTheme) {
        return sousSousThemeService.update(sousSousTheme);
    }
}
