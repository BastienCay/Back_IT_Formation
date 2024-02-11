package com.bac.itformation.repository;

import com.bac.itformation.model.SessionFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SessionFormationRepository extends JpaRepository<SessionFormation, Long> {

    @Query(value = "SELECT sf FROM session_formation sf " +
            "INNER JOIN stagiaire s ON stagiaire_session_formation.s.id = s.id " +
            "AND s.id = :id ", nativeQuery = true)
    public List<SessionFormation> getSessionByStagiaireId(@Param("id") Long id);

}
