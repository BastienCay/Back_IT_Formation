package com.bac.itformation.service;

import com.bac.itformation.dto.AdresseDTO;
import com.bac.itformation.model.Adresse;

import java.util.List;

public interface AdresseService {

    public List<Adresse> findAll();

    public Adresse findById(Long id);

    public void addAdresse(AdresseDTO adresseDto);
    public Adresse save(Adresse adresse);

    public Adresse update(Adresse adresse);

    public void deleteById(Long id);

    public void deleteAll();
}
