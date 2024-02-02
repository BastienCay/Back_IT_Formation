package com.bac.itformation.service;

import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.Session;
import com.bac.itformation.repository.SessionRepository;
import com.bac.itformation.repository.SessionRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SessionService {

    private final SessionRepository sessionRepository;
    private final JdbcTemplate jdbcTemplate;

    public SessionService(SessionRepository sessionRepository, JdbcTemplate jdbcTemplate) {
        this.sessionRepository = sessionRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    public Session findById(Long id) {
        return sessionRepository.findById(id).orElseThrow( () -> new NotFoundException("Session inconnue !"));
    }

    public Session save(Session compte) { return sessionRepository.save(compte);}


    public Session update(Session compte) {
        return sessionRepository.save(compte);
    }

    public void deleteById(Long id) {
        sessionRepository.deleteById(id);
    }

    public void deleteAll() {
        sessionRepository.deleteAll();
    }
}
