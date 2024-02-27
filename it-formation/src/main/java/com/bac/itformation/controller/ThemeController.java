package com.bac.itformation.controller;

import com.bac.itformation.dto.ThemeDTO;
import com.bac.itformation.model.Theme;
import com.bac.itformation.service.serviceImpl.ThemeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/themes")
@CrossOrigin
public class ThemeController {

    private final ThemeServiceImpl themeServiceImpl;

    public ThemeController(ThemeServiceImpl themeServiceImpl) {
        this.themeServiceImpl = themeServiceImpl;
    }

    @GetMapping("/all")
    public List<Theme> findAll() {
        return themeServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public Theme findById(@PathVariable Long id) {
        return themeServiceImpl.findById(id);
    }

    @PostMapping("/add")
    public void save(@RequestBody ThemeDTO themeDto) {
        themeServiceImpl.addTheme(themeDto);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        themeServiceImpl.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        themeServiceImpl.deleteById(id);
    }

    @PatchMapping("/update")
    public Theme update(@RequestBody Theme theme) {
        return themeServiceImpl.update(theme);
    }
}
