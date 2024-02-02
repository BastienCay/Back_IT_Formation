package com.bac.itformation.controller;

import com.bac.itformation.model.User;
import com.bac.itformation.service.UserService;
import com.bac.itformation.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/themes")
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/add")
    public User save(@RequestBody User user) {
        return userService.save(user);
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
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
}
