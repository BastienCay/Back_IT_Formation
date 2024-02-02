package com.bac.itformation.controller;

import com.bac.itformation.model.Session;
import com.bac.itformation.service.SessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
@CrossOrigin
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/all")
    public List<Session> findAll() {
        return sessionService.findAll();
    }

    @GetMapping("/{id}")
    public Session findById(@PathVariable Long id) {
        return sessionService.findById(id);
    }

    @PostMapping("/add")
    public Session save(@RequestBody Session session) {
        return sessionService.save(session);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        sessionService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        sessionService.deleteById(id);
    }

    @PatchMapping("/update")
    public Session update(@RequestBody Session session) {
        return sessionService.update(session);
    }
}
