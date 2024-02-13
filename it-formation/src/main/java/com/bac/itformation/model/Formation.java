package com.bac.itformation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity(name = "formation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formation{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    private String nom;

    @NotNull
    @Size(min = 10, max = 200)
    private String descriptionMinimum;

    @NotNull
    @Size(min = 10, max = 600)
    private String descriptionDetailler;

    @NotNull
    @Size(min = 120, max = 10000)
    private Integer prix;

    @NotNull
    @Size(min = 1, max = 1000)
    private Integer nbrJour;

    @NotNull
    @Size(min = 6, max = 6)
    @Column(name = "refer")
    private String reference;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TypeFormation typeFormation;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PreRequis preRequis;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TypeCertification typeCertification;

    @NotNull
    private String metiers;

    @ManyToOne
    private Adresse adresse;

    @ManyToOne
    private SousTheme sousTheme;
}
