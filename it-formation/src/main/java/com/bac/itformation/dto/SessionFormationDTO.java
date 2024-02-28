package com.bac.itformation.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionFormationDTO {

    private Long id;

    private Date dateDebut;

    private Date dateFin;

    private Long idFormation;

    private Long idFormateur;

}
