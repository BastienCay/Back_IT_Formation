package com.bac.itformation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    @NotNull
    @Size(min = 2, max = 50)
    private String nom;
    @NotNull
    @Size(min = 2, max = 50)
    private String prenom;
    @NotNull
    @Email
    private String mail;
    @NotNull
    private String telephone;

    @ManyToOne
    private Compte compte;
}
