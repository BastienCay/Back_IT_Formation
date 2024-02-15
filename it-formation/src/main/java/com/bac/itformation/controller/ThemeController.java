package com.bac.itformation.controller;

import com.bac.itformation.model.Theme;
import com.bac.itformation.service.ThemeService;
import com.bac.itformation.service.ThemeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/themes")
@CrossOrigin
public class ThemeController {

    private final ThemeService themeService;

    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping("/all")
    public List<Theme> findAll() {
        return themeService.findAll();
    }

    @GetMapping("/{id}")
    public Theme findById(@PathVariable Long id) {
        return themeService.findById(id);
    }



    @PostMapping("/add")
    public Theme save(@RequestBody Theme theme) {
        return themeService.save(theme);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        themeService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        themeService.deleteById(id);
    }

    @PatchMapping("/update")
    public Theme update(@RequestBody Theme theme) {
        return themeService.update(theme);
    }
}
