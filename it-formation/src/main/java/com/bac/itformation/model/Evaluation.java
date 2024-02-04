package com.bac.itformation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(Evaluation.class)
/**
 * Entite permettant la representation d'une évaluation pour un utilisateur sur une formation
 */
public class Evaluation {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_user")
    private Long userId;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_session")
    private Long sessionId;

    @Size(min = 1, max = 5)
    private Integer moyenneLocaux;

    @Size(min = 1, max = 5)
    private Integer moyenneFormation;

    @Size(min = 1, max = 5)
    private Integer moyenneFormateur;

}
