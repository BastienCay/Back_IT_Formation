package com.bac.itformation.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdresseDTO {
    private Long id;
    private String codePostal;
    private String ville;
    private String rue;
    private String pays;

}
