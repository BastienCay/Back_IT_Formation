package com.bac.itformation.controller;

import com.bac.itformation.dto.SessionUserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sessions-user")
public class SessionUserController {

    @GetMapping("/{id}")
    public List<SessionUserDTO> getSessionsByUser(@PathVariable Long id){

        return null;
    }

}
