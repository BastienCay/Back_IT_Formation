package com.bac.itformation.controller;

import com.bac.itformation.model.SousTheme;
import com.bac.itformation.service.SousThemeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sous-themes")
@CrossOrigin
public class SousThemeController {

    private final SousThemeService sousThemeService;

    public SousThemeController(SousThemeService sousThemeService) {
        this.sousThemeService = sousThemeService;
    }

    @GetMapping("/all")
    public List<SousTheme> findAll() {
        return sousThemeService.findAll();
    }

    @GetMapping("/{id}")
    public SousTheme findById(@PathVariable Long id) {
        return sousThemeService.findById(id);
    }

    @PostMapping("/add")
    public SousTheme save(@RequestBody SousTheme sousTheme) {
        return sousThemeService.save(sousTheme);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        sousThemeService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        sousThemeService.deleteById(id);
    }

    @PatchMapping("/update")
    public SousTheme update(@RequestBody SousTheme sousTheme) {
        return sousThemeService.update(sousTheme);
    }
}
