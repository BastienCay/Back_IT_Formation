package com.bac.itformation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Entite permettant de représenter une session d'une formation comprenant une date de début,
 * une date de fin, une formation, une liste de formateurs et une liste de stagiaire
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionFormation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @NotNull
    @ManyToOne
    private Formation formation;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formateurId")
    @JsonIgnore
    private Formateur formateur;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(name = "stagiaire_session_formation",
            joinColumns = @JoinColumn(name = "sessionFormationId"),
            inverseJoinColumns = @JoinColumn(name = "stagiaireId"))
    private List<Stagiaire> stagiaires;

    @OneToMany(mappedBy="sessionFormation", fetch = FetchType.LAZY)
    private List<EvaluationStagiaire> evaluationStagiaires;

}
