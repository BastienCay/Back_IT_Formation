package com.bac.itformation.service;

import com.bac.itformation.dto.FormateurDTO;
import com.bac.itformation.model.Formateur;

import java.util.List;

public interface FormateurService {

    public List<Formateur> findAll();

    public List<FormateurDTO> getAllFormateurs();

    public Formateur findById(Long id);

    public Formateur save(Formateur formateur);

    public Formateur update(Formateur formateur);

    public void deleteById(Long id);

    public void deleteAll();

}
