package com.bac.itformation.service;

import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.SessionFormation;
import com.bac.itformation.repository.SessionFormationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionFormationService {

    private final SessionFormationRepository sessionSessionRepository;
    public SessionFormationService(SessionFormationRepository sessionSessionRepository) {
        this.sessionSessionRepository = sessionSessionRepository;
    }

    public List<SessionFormation> findAll() {
        return sessionSessionRepository.findAll();
    }

    public SessionFormation findById(Long id) {
        return sessionSessionRepository.findById(id).orElseThrow( () -> new NotFoundException("Session inconnue !"));
    }

    public SessionFormation save(SessionFormation sessionFormation) { return sessionSessionRepository.save(sessionFormation);}


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
