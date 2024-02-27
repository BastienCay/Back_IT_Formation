package com.bac.itformation.service;

import com.bac.itformation.dto.ThemeDTO;
import com.bac.itformation.model.Theme;

import java.util.List;

public interface ThemeService {

    public List<Theme> findAll();

    public Theme findByDesignation(String designation);
    public Theme findById(Long id);

    public void addTheme(ThemeDTO themeDTO);

    public Theme save(Theme theme);

    public Theme update(Theme theme);

    public void deleteById(Long id);

    public void deleteAll();
}
