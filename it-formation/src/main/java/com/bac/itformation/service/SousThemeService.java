package com.bac.itformation.service;

import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.SousTheme;
import com.bac.itformation.repository.SousThemeRepository;
import com.bac.itformation.repository.ThemeRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SousThemeService {

    private final SousThemeRepository sousThemeRepository;
    private final ThemeRepository themeRepository;
    private final JdbcTemplate jdbcTemplate;

    public SousThemeService(SousThemeRepository sousThemeRepository, ThemeRepository themeRepository, JdbcTemplate jdbcTemplate) {
        this.sousThemeRepository = sousThemeRepository;
        this.themeRepository = themeRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SousTheme> findAll() {
        return sousThemeRepository.findAll();
    }

    public SousTheme findById(Long id) {
        return sousThemeRepository.findById(id).orElseThrow( () -> new NotFoundException("SousTheme inconnue !"));
    }


    public SousTheme save(SousTheme sousTheme) {

        if(sousTheme.getTheme().getId() == null){
            sousTheme.setTheme(themeRepository.findByDesignation(sousTheme.getTheme().getDesignation()));
        }
        return sousThemeRepository.save(sousTheme);
    }

    public SousTheme saveBis(SousTheme sousTheme) {

        return sousThemeRepository.save(sousTheme);
    }


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
