package com.bac.itformation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @Size(min = 2, max = 50)
    private String nom;

    @NotNull
    @Size(min = 10, max = 100)
    private String descript;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TypeCertification typeCertification;

    private String metiers;

    @ManyToOne
    private Adresse adresse;
    @OneToMany
    private List<SousTheme> sousThemes;
}
