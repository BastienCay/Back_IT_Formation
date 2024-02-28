package com.bac.itformation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormateurDTO {

    private Long id;
    private Long idUtilisateur;
    private String nom;
    private String prenom;

}
