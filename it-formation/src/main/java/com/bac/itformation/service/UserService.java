package com.bac.itformation.service;

import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.Utilisateur;
import com.bac.itformation.repository.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final JdbcTemplate jdbcTemplate;

    public UserService(UserRepository userRepository, JdbcTemplate jdbcTemplate) {
        this.userRepository = userRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Utilisateur> findAll() {
        return userRepository.findAll();
    }

    public Utilisateur findById(Long id) {
        return userRepository.findById(id).orElseThrow( () -> new NotFoundException("User inconnue !"));
    }

    public Utilisateur save(Utilisateur utilisateur) { return userRepository.save(utilisateur);}


    public Utilisateur update(Utilisateur utilisateur) {
        return userRepository.save(utilisateur);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }
}
