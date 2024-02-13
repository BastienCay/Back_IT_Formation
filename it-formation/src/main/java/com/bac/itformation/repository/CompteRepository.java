package com.bac.itformation.repository;

import com.bac.itformation.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

    Compte findByMotDePasseAndIdentifiant(String motDePasse, String identifiant);

}
