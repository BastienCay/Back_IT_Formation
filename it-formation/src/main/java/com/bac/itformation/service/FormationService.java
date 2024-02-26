package com.bac.itformation.service;

import com.bac.itformation.dto.FormationDTO;
import com.bac.itformation.model.Formation;

import java.util.List;

public interface FormationService {

    public List<Formation> findAll();
    public Formation findById(Long id);
    public Formation save(Formation formation);
    public void addFormation(FormationDTO formationDto);
    public Formation update(Formation formation);
    public void deleteById(Long id);

    public void deleteAll();
}
