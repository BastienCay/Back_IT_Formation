package com.bac.itformation.service;

import com.bac.itformation.dto.SessionUserDTO;
import com.bac.itformation.model.Formation;
import com.bac.itformation.model.SessionFormation;
import com.bac.itformation.repository.SessionFormationRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionUserService {

    private final SessionFormationRepository sessionSessionRepository;
    public SessionUserService(SessionFormationRepository sessionSessionRepository) {
        this.sessionSessionRepository = sessionSessionRepository;
    }
    public List<SessionUserDTO> getSessionByUser(Long id){
        List<SessionFormation> sessionFormation = sessionSessionRepository.getSessionByStagiaireId(id);

        List<SessionUserDTO> listDto = new ArrayList<>();
        for (SessionFormation session : sessionFormation) {

            SessionUserDTO dto = mapToDto(session);
            listDto.add(dto);
        }



        return listDto;
    }

    private SessionUserDTO mapToDto(SessionFormation sessionFormation) {
        SessionUserDTO dto = new SessionUserDTO();
        dto.setDateDebut(sessionFormation.getDateDebut());

        return dto;
    }



}
