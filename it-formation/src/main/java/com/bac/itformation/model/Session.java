package com.bac.itformation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @NotBlank
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @ManyToOne
    private List<Formateur> formateurs;

    @ManyToOne
    private List<User> users;

    @NotBlank
    @OneToMany
    private Formation formation;
}
