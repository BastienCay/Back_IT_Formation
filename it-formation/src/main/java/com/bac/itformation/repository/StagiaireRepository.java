package com.bac.itformation.repository;

import com.bac.itformation.model.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {

    @Query(value = "SELECT s FROM Stagiaire s " +
            "WHERE s.utilisateur.nom = :nom")
    Optional<Stagiaire> getStagiaireByUserTelephone(@Param("nom") String nom);
}
