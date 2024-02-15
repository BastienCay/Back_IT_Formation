package com.bac.itformation.repository;

import com.bac.itformation.model.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Long> {
    @Query(value = "SELECT adresse from Adresse adresse " +
            "WHERE adresse.id = :id")
    Adresse getAdresseById (@Param("id") Long id);

    Adresse findByVille(String ville);
}
