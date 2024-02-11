package com.bac.itformation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private Long idCompte;

    @NotNull
    @Size(min = 8, max = 50)
    private String motDePasse;

    @NotNull
    @Size(min = 8, max = 50)
    private String identifiant;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TypeDeCompte typeCompte;

    @ManyToOne
    private Utilisateur utilisateur;
}
