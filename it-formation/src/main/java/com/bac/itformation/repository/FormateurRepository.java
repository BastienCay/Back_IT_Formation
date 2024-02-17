package com.bac.itformation.repository;

import com.bac.itformation.model.Adresse;
import com.bac.itformation.model.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long> {
    @Query("SELECT formateur FROM Formateur formateur " +
            "WHERE formateur.utilisateur.id = :userId ")
    Formateur getFormateurByUserId(@Param("userId") Long userId);
}
