package com.bac.itformation.repository;

import com.bac.itformation.model.Adresse;
import com.bac.itformation.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {
    @Query("SELECT formation FROM Formation formation " +
            "WHERE formation.reference = :refFormation ")
    Formation getFormationByRef (@Param("refFormation")String refFormation);
}
