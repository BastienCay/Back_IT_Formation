package com.bac.itformation.service;

import com.bac.itformation.dto.SessionUserDTO;
import com.bac.itformation.model.Formation;
import com.bac.itformation.model.SessionFormation;
import com.bac.itformation.repository.EvaluationRepository;
import com.bac.itformation.repository.SessionFormationRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SessionUserService {

    private final SessionFormationRepository sessionSessionRepository;
    private final EvaluationRepository evaluationRepository;

    public SessionUserService(SessionFormationRepository sessionSessionRepository, EvaluationRepository evaluationRepository) {
        this.sessionSessionRepository = sessionSessionRepository;
        this.evaluationRepository = evaluationRepository;
    }
    public List<SessionUserDTO> getSessionByUser(Long id){
        List<SessionUserDTO> listDto = new ArrayList<>();

        List<SessionFormation> sessionFormation = sessionSessionRepository.getSessionByStagiaireId(id);

        if(!sessionFormation.isEmpty()) {
            for (SessionFormation session : sessionFormation) {
                boolean isEvaluee = isEvaluee(session.getSessionFormationId());
                SessionUserDTO dto = mapToDto(session, isEvaluee);
                listDto.add(dto);
            }
        }

        return listDto;
    }

    private SessionUserDTO mapToDto(SessionFormation sessionFormation, boolean isEvaluee) {
        SessionUserDTO dto = new SessionUserDTO();
        dto.setDateDebut(sessionFormation.getDateDebut());
        dto.setEvaluee(isEvaluee);
        dto.setNomFormation(sessionFormation.getFormation().getNom());
        dto.setThemeFormation(sessionFormation.getFormation().getSousTheme().getDesignation());
        dto.setDureeFormation(sessionFormation.getFormation().getNbrJour());

        return dto;
    }

    private boolean isEvaluee(Long id){
    Optional<Boolean> optIsEvaluee = evaluationRepository.isSessionEvaluer(id);
    if (optIsEvaluee.isPresent()) {
        return optIsEvaluee.get();
    }
        return false;
    }



}
