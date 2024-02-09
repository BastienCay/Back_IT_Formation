package com.bac.itformation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class SessionFormation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionFormationId;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @NotNull
    @ManyToOne
    private Formation formation;

    @ManyToMany
    @JoinTable(
            name = "formateur_session_formations",
            joinColumns = @JoinColumn(name = "session_formation_id"),
            inverseJoinColumns = @JoinColumn(name = "formateur_id"))
    private List<Formateur> formateurs;

    @ManyToMany
    @JoinTable(
            name = "stagiaire_session_formation",
            joinColumns = @JoinColumn(name = "session_formation_id"),
            inverseJoinColumns = @JoinColumn(name = "stagiaire_id"))
    private List<Stagiaire> stagiaires;

}
