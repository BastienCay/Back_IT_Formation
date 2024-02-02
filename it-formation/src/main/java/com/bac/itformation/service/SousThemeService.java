package com.bac.itformation.service;

import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.SousTheme;
import com.bac.itformation.model.SousTheme;
import com.bac.itformation.repository.SousThemeRepository;
import com.bac.itformation.repository.SousThemeRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SousThemeService {

    private final SousThemeRepository sousThemeRepository;
    private final JdbcTemplate jdbcTemplate;

    public SousThemeService(SousThemeRepository sousThemeRepository, JdbcTemplate jdbcTemplate) {
        this.sousThemeRepository = sousThemeRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SousTheme> findAll() {
        return sousThemeRepository.findAll();
    }

    public SousTheme findById(Long id) {
        return sousThemeRepository.findById(id).orElseThrow( () -> new NotFoundException("SousTheme inconnue !"));
    }

    public SousTheme save(SousTheme sousTheme) { return sousThemeRepository.save(sousTheme);}


    public SousTheme update(SousTheme sousTheme) {
        return sousThemeRepository.save(sousTheme);
    }

    public void deleteById(Long id) {
        sousThemeRepository.deleteById(id);
    }

    public void deleteAll() {
        sousThemeRepository.deleteAll();
    }
}
