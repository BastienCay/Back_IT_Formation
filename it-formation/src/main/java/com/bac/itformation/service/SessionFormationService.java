package com.bac.itformation.service;

import com.bac.itformation.dto.SessionFormationDTO;
import com.bac.itformation.model.SessionFormation;

import java.util.List;

public interface SessionFormationService {

    public List<SessionFormation> findAll();

    public SessionFormation findById(Long id);

    public SessionFormation addSessionFormation(SessionFormationDTO sessionFormationDto);

    public SessionFormation addStagiaire(Long idSession, String nom);

    public SessionFormation update(SessionFormation sessionFormation);

    public void deleteById(Long id);

    public void deleteAll();

}

