package com.bac.itformation.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Embeddable
public class EvaluationPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idUser;
    private Long idSession;

}
