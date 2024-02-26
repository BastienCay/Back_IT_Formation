package com.bac.itformation.service.serviceImpl;

import com.bac.itformation.dto.FormationDTO;
import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.Adresse;
import com.bac.itformation.model.Formation;
import com.bac.itformation.model.SousTheme;
import com.bac.itformation.repository.AdresseRepository;
import com.bac.itformation.repository.FormationRepository;
import com.bac.itformation.repository.SousThemeRepository;
import com.bac.itformation.service.FormationService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FormationServiceImpl implements FormationService {

    private final FormationRepository formationRepository;
    private final AdresseRepository adresseRepository;
    private final SousThemeRepository sousThemeRepository;
    private final JdbcTemplate jdbcTemplate;

    public FormationServiceImpl(FormationRepository formationRepository, JdbcTemplate jdbcTemplate, AdresseRepository adresseRepository, SousThemeRepository sousThemeRepository) {
        this.formationRepository = formationRepository;
        this.jdbcTemplate = jdbcTemplate;
        this.adresseRepository = adresseRepository;
        this.sousThemeRepository = sousThemeRepository;
    }

    @Override
    public List<Formation> findAll() {
        return formationRepository.findAll();
    }

    @Override
    public Formation findById(Long id) {
        return formationRepository.findById(id).orElseThrow( () -> new NotFoundException("Formation inconnue !"));
    }

    @Override
    @Transactional(noRollbackForClassName = "FormationService")
    public Formation save(Formation formation) {

        if(formation.getAdresse().getId() == null){
            formation.setAdresse(adresseRepository.findByVille(formation.getAdresse().getVille()));
        }

        if (formation.getSousTheme().getId() == null){
            formation.setSousTheme(sousThemeRepository.findByDesignation(formation.getSousTheme().getDesignation()));
        }

        return formationRepository.save(formation);
    }

    @Override
    public void addFormation(FormationDTO formationDto) {

        Formation formation = new Formation();

        try {
            if (formationDto.getIdAdresse() != null) {
                Adresse adresse = adresseRepository.getAdresseById(formationDto.getIdAdresse());
                formation.setAdresse(adresse);
            }
            if (formationDto.getIdSousTheme() != null) {
                SousTheme sousTheme = sousThemeRepository.getSousThemeById(formationDto.getIdSousTheme());
                formation.setSousTheme(sousTheme);
            }
            formation.setDescriptionDetailler(formationDto.getDescriptionDetaillee());
            formation.setDescriptionMinimum(formationDto.getDescriptionMinimum());
            formation.setMetiers(formationDto.getMetier());
            formation.setNbrJour(formationDto.getNbreJour());
            formation.setNom(formationDto.getNom());
            formation.setPreRequis(formationDto.getPrerequis());
            formation.setPrix(formationDto.getPrix());
            formation.setReference(formationDto.getReference());
            formation.setTypeCertification(formationDto.getTypeCertification());
            formation.setTypeFormation(formationDto.getTypeFormation());

            formationRepository.save(formation);
        } catch (Exception e) {

        }
    }


    @Override
    public Formation update(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public void deleteById(Long id) {
        formationRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        formationRepository.deleteAll();
    }
}
