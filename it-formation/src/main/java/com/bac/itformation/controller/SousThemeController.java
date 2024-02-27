package com.bac.itformation.controller;

import com.bac.itformation.dto.SousThemeDTO;
import com.bac.itformation.model.SousTheme;
import com.bac.itformation.service.serviceImpl.SousThemeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sous-themes")
@CrossOrigin
public class SousThemeController {

    private final SousThemeServiceImpl sousThemeServiceImpl;

    public SousThemeController(SousThemeServiceImpl sousThemeServiceImpl) {
        this.sousThemeServiceImpl = sousThemeServiceImpl;
    }

    @GetMapping("/all")
    public List<SousTheme> findAll() {
        return sousThemeServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public SousTheme findById(@PathVariable Long id) {
        return sousThemeServiceImpl.findById(id);
    }

    @PostMapping("/add")
    public void save(@RequestBody SousThemeDTO sousThemeDto) {
        sousThemeServiceImpl.addSousTheme(sousThemeDto);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        sousThemeServiceImpl.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        sousThemeServiceImpl.deleteById(id);
    }

    @PatchMapping("/update")
    public SousTheme update(@RequestBody SousTheme sousTheme) {
        return sousThemeServiceImpl.update(sousTheme);
    }
}
