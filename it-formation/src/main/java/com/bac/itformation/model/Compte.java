package com.bac.itformation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entite permettant la representation du compte d'un utilisateur avec un certain niveau d'autorisation
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 8, max = 50)
    private String motDePasse;

    @NotBlank
    @Size(min = 8, max = 50)
    private String identifiant;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private TypeDeCompte typeDeCompte;

}
