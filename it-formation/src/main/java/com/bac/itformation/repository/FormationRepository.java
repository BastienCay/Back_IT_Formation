package com.bac.itformation.repository;

import com.bac.itformation.model.Adresse;
import com.bac.itformation.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {
}
