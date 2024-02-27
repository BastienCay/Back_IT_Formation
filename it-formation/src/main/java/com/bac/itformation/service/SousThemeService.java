package com.bac.itformation.service;

import com.bac.itformation.model.SousTheme;

import java.util.List;

public interface SousThemeService {

    public List<SousTheme> findAll();

    public SousTheme findById(Long id);

    public SousTheme save(SousTheme sousTheme);

    public SousTheme update(SousTheme sousTheme);

    public void deleteById(Long id);

    public void deleteAll();




}
