package com.bac.itformation.service;

import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.Formation;
import com.bac.itformation.model.SessionFormation;
import com.bac.itformation.repository.FormateurRepository;
import com.bac.itformation.repository.FormationRepository;
import com.bac.itformation.repository.SessionFormationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SessionFormationService {

    private final SessionFormationRepository sessionSessionRepository;
    private final FormateurRepository formateurRepository;
    private final FormationRepository formationRepository;
    public SessionFormationService(SessionFormationRepository sessionSessionRepository, FormateurRepository formateurRepository, FormationRepository formationRepository) {
        this.sessionSessionRepository = sessionSessionRepository;
        this.formateurRepository = formateurRepository;
        this.formationRepository = formationRepository;
    }

    public List<SessionFormation> findAll() {
        return sessionSessionRepository.findAll();
    }

    public SessionFormation findById(Long id) {
        return sessionSessionRepository.findById(id).orElseThrow( () -> new NotFoundException("Session inconnue !"));
    }

    public SessionFormation addSessionFormation(SessionFormation sessionFormation) {
        if (sessionFormation.getFormateur().getId() == null) {
          sessionFormation.setFormateur(formateurRepository.getFormateurByUserId(sessionFormation.getFormateur().getUtilisateur().getId()));
        }

        if (sessionFormation.getFormation().getId() == null) {
            sessionFormation.setFormation(formationRepository.getFormationByRef(sessionFormation.getFormation().getReference()));
        }

        return sessionSessionRepository.save(sessionFormation);}


    public SessionFormation update(SessionFormation sessionFormation) {
        return sessionSessionRepository.save(sessionFormation);
    }

    public void deleteById(Long id) {
        sessionSessionRepository.deleteById(id);
    }

    public void deleteAll() {
        sessionSessionRepository.deleteAll();
    }
}
