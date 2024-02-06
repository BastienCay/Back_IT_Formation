package com.bac.itformation.repository;

import com.bac.itformation.model.SessionFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionFormationRepository extends JpaRepository<SessionFormation, Long> {
}
