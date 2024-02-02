package com.bac.itformation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 2, max = 50)
    private String designation;
    @NotBlank
    private String description;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private TypeCertification typeCertification;

    private String metiers;

    @OneToMany
    private Adresse adresse;

    @OneToMany
    private List<Sous_Theme> sousThemes;
}
