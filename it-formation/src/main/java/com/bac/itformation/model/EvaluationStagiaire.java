package com.bac.itformation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationStagiaire {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stagiaire_id")
    private Stagiaire stagiaire;

    @ManyToOne
    @JoinColumn(name = "session_formation_id")
    private SessionFormation sessionFormation;


    private Integer noteLocaux;
    private Integer noteFormation;
    private Integer noteFormateur;

    @Max(250)
    private String commentaire;
    private boolean isEvaluer;
}
