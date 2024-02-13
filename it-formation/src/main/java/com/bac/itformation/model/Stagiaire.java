package com.bac.itformation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JsonBackReference
    private Utilisateur utilisateur;

    @ManyToMany(mappedBy = "stagiaires")
    private List<SessionFormation> sessionFormations = new ArrayList<>();

    @OneToMany(mappedBy = "stagiaire")
    private List<EvaluationStagiaire> evaluationStagiaires;
}
