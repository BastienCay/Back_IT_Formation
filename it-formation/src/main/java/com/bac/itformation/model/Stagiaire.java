package com.bac.itformation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stagiaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JsonIgnore
    private Utilisateur utilisateur;

    @ManyToMany(mappedBy = "stagiaires", fetch = FetchType.LAZY)
    private List<SessionFormation> sessionFormations = new ArrayList<>();

    @OneToMany(mappedBy = "stagiaire", fetch = FetchType.LAZY)
    private List<EvaluationStagiaire> evaluationStagiaires;
}
