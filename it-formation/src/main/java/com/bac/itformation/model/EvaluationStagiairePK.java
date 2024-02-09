package com.bac.itformation.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class EvaluationStagiairePK implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long evaluationId;
    private Long stagiaireId;
    private Long sessionFormationId;

}
