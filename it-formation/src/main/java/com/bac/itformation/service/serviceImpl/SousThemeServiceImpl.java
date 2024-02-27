package com.bac.itformation.service.serviceImpl;

import com.bac.itformation.dto.SousThemeDTO;
import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.SousTheme;
import com.bac.itformation.model.Theme;
import com.bac.itformation.repository.SousThemeRepository;
import com.bac.itformation.repository.ThemeRepository;
import com.bac.itformation.service.SousThemeService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SousThemeServiceImpl implements SousThemeService {

    private final SousThemeRepository sousThemeRepository;
    private final ThemeRepository themeRepository;
    private final JdbcTemplate jdbcTemplate;

    public SousThemeServiceImpl(SousThemeRepository sousThemeRepository, ThemeRepository themeRepository, JdbcTemplate jdbcTemplate) {
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

    public void addSousTheme(SousThemeDTO sousThemeDto){
        SousTheme sousTheme = new SousTheme();
        try{
            System.out.println(sousThemeDto.getIdTheme());
            if (sousThemeDto.getIdTheme() != null) {
                Theme theme = themeRepository.getById(sousThemeDto.getIdTheme());
                sousTheme.setTheme(theme);
            }

            sousTheme.setDesignation(sousThemeDto.getDesignation());

            sousThemeRepository.save(sousTheme);

        }catch (Exception e){

        }
    }

    public SousTheme save(SousTheme sousTheme) {

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
