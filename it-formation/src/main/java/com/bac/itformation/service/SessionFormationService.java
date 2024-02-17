package com.bac.itformation.service;

import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.Formateur;
import com.bac.itformation.model.Formation;
import com.bac.itformation.model.SessionFormation;
import com.bac.itformation.model.Stagiaire;
import com.bac.itformation.repository.FormateurRepository;
import com.bac.itformation.repository.FormationRepository;
import com.bac.itformation.repository.SessionFormationRepository;
import com.bac.itformation.repository.StagiaireRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SessionFormationService {

    private final SessionFormationRepository sessionRepository;
    private final FormateurRepository formateurRepository;
    private final FormationRepository formationRepository;
    private final StagiaireRepository stagiaireRepository;
    public SessionFormationService(SessionFormationRepository sessionRepository, FormateurRepository formateurRepository, FormationRepository formationRepository,
                                   StagiaireRepository stagiaireRepository) {
        this.sessionRepository = sessionRepository;
        this.formateurRepository = formateurRepository;
        this.formationRepository = formationRepository;
        this.stagiaireRepository = stagiaireRepository;
    }

    public List<SessionFormation> findAll() {
        return sessionRepository.findAll();
    }

    public SessionFormation findById(Long id) {
        return sessionRepository.findById(id).orElseThrow( () -> new NotFoundException("Session inconnue !"));
    }

    public SessionFormation addSessionFormation(String telephone, SessionFormation sessionFormation) {

        if (sessionFormation.getFormation().getId() == null) {
            sessionFormation.setFormation(formationRepository.getFormationByRef(sessionFormation.getFormation().getReference()));
        }
        Formateur formateur = formateurRepository.getFormateurByTelephone(telephone);
        sessionFormation.setFormateur(formateur);
        return sessionRepository.save(sessionFormation);
    }

    public SessionFormation addStagiaire(Long idSession, String nom) {
       SessionFormation session = sessionRepository.findById(idSession).orElseThrow( () ->
                new NotFoundException("Aucune session trouvée !"));
       Optional<Stagiaire> newStagiaire = stagiaireRepository.getStagiaireByUserTelephone(nom);
    if (newStagiaire.isEmpty()) {
        throw new NotFoundException("Aucun stagiaire trouvé !");
    }

    session.getStagiaires().add(newStagiaire.get());
    return sessionRepository.save(session);
    }


    public SessionFormation update(SessionFormation sessionFormation) {
        return sessionRepository.save(sessionFormation);
    }

    public void deleteById(Long id) {
        sessionRepository.deleteById(id);
    }

    public void deleteAll() {
        sessionRepository.deleteAll();
    }
}
