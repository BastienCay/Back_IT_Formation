package com.bac.itformation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.Mapping;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stagiaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Email
    private String mail;

    @NotNull
    private String telephone;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Utilisateur utilisateur;


    @ManyToMany(mappedBy = "stagiaires")
    private List<SessionFormation> sessionFormations = new ArrayList<>();

    @OneToMany(mappedBy = "stagiaire")
    private List<EvaluationStagiaire> evaluationStagiaires;
}
