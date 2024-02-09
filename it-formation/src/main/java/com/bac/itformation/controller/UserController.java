package com.bac.itformation.controller;

import com.bac.itformation.model.Utilisateur;
import com.bac.itformation.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<Utilisateur> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Utilisateur findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/add")
    public Utilisateur save(@RequestBody Utilisateur utilisateur) {
        return userService.save(utilisateur);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        userService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PatchMapping("/update")
    public Utilisateur update(@RequestBody Utilisateur utilisateur) {
        return userService.update(utilisateur);
    }
}
