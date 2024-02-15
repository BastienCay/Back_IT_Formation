package com.bac.itformation.service;

import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.Theme;
import com.bac.itformation.model.Theme;
import com.bac.itformation.repository.ThemeRepository;
import com.bac.itformation.repository.ThemeRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ThemeService {

    private final ThemeRepository themeRepository;
    private final JdbcTemplate jdbcTemplate;

    public ThemeService(ThemeRepository themeRepository, JdbcTemplate jdbcTemplate) {
        this.themeRepository = themeRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Theme> findAll() {
        return themeRepository.findAll();
    }

    public Theme findByDesignation(String designation) {
        return themeRepository.findByDesignation(designation);
    }
    public Theme findById(Long id) {
        return themeRepository.findById(id).orElseThrow( () -> new NotFoundException("Theme inconnue !"));
    }

    public Theme save(Theme theme) { return themeRepository.save(theme);}



    public Theme update(Theme theme) {
        return themeRepository.save(theme);
    }

    public void deleteById(Long id) {
        themeRepository.deleteById(id);
    }

    public void deleteAll() {
        themeRepository.deleteAll();
    }
}
