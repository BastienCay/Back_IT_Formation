package com.bac.itformation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationStagiaire {

    @EmbeddedId
    private EvaluationStagiairePK evaluationStagiairePK;

    private Integer noteLocaux;
    private Integer noteFormation;
    private Integer noteFormateur;

    @Max(250)
    private String commentaire;
    private boolean isEvaluer;
}
