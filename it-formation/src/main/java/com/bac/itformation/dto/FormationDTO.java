package com.bac.itformation.dto;

import com.bac.itformation.model.PreRequis;
import com.bac.itformation.model.TypeCertification;
import com.bac.itformation.model.TypeFormation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormationDTO {

    private String descriptionDetaillee;
    private String descriptionMinimum;
    private String metier;
    private Integer nbreJour;
    private String nom;
    private PreRequis prerequis;
    private Integer prix;
    private String reference;
    private TypeCertification typeCertification;
    private TypeFormation typeFormation;

    //ADRESSE
    private Long idAdresse;

    //THEME
    private Long idTheme;
    //SOUS-THEME
    private Long idSousTheme;
}
