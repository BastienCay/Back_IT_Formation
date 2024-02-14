package com.bac.itformation.service;

import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.SousSousTheme;
import com.bac.itformation.repository.SousSousThemeRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SousSousThemeService {

    private final SousSousThemeRepository sousSousThemeRepository;
    private final JdbcTemplate jdbcTemplate;

    public SousSousThemeService(SousSousThemeRepository sousSousThemeRepository, JdbcTemplate jdbcTemplate) {
        this.sousSousThemeRepository = sousSousThemeRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SousSousTheme> findAll() {
        return sousSousThemeRepository.findAll();
    }

    public SousSousTheme findById(Long id) {
        return sousSousThemeRepository.findById(id).orElseThrow( () -> new NotFoundException("SousSousTheme inconnue !"));
    }

    public SousSousTheme save(SousSousTheme sousSousTheme) { return sousSousThemeRepository.save(sousSousTheme);}


    public SousSousTheme update(SousSousTheme sousSousTheme) {
        return sousSousThemeRepository.save(sousSousTheme);
    }

    public void deleteById(Long id) {
        sousSousThemeRepository.deleteById(id);
    }

    public void deleteAll() {
        sousSousThemeRepository.deleteAll();
    }
}
