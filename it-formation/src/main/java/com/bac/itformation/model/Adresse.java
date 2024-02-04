package com.bac.itformation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entite permettant la representation d'une addresse indiquant le lieu ou se situe une formation
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 0,max = 5)
    private String codePostal;

    @NotNull
    @Max(50)
    private String ville;

    @NotNull
    @Max(50)
    private String rue;

    @NotNull
    @Max(50)
    private String pays;
}
