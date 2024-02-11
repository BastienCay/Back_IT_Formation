package com.bac.itformation.controller;

import com.bac.itformation.dto.SessionUserDTO;
import com.bac.itformation.repository.EvaluationRepository;
import com.bac.itformation.repository.SessionFormationRepository;
import com.bac.itformation.service.SessionUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/sessions-user")
public class SessionUserController {

    private final SessionUserService sessionUserService;

    public SessionUserController(SessionUserService sessionUserService) {
        this.sessionUserService = sessionUserService;
    }

    @GetMapping("/{id}")
    public List<SessionUserDTO> getSessionsByUser(@PathVariable Long id){
        Objects.requireNonNull(id, "L'id du stagiaire ne peut pas être null");

    return sessionUserService.getSessionByUser(id);
    }

}
