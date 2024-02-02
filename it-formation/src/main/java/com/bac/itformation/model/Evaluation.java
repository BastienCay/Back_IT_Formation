package com.bac.itformation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(Evaluation.class)
public class Evaluation {

    @Id
    @OneToMany
    @JoinColumn(name = "idUser")
    private Long id_User;
    @Id
    @OneToMany
    @JoinColumn(name = "idSession")
    private Long id_Session;

    @Size(min = 1, max = 5)
    private Integer moyenneLocaux;
    @Size(min = 1, max = 5)
    private Integer moyenneFormation;
    @Size(min = 1, max = 5)
    private Integer moyenneFormateur;

}
