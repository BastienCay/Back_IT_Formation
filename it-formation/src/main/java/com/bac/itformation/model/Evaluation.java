package com.bac.itformation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evaluation{

    @EmbeddedId
    private EvaluationPK evaluationPK;

    @NotNull
    private Integer moyenneLocaux;
    @NotNull
    private Integer moyenneFormation;
    @NotNull
    private Integer moyenneFormateur;
    private String commentaire;
}
