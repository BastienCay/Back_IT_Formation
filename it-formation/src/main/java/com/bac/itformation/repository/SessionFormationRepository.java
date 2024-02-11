package com.bac.itformation.repository;

import com.bac.itformation.model.SessionFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SessionFormationRepository extends JpaRepository<SessionFormation, Long> {

    @Query(value = "SELECT * FROM session_formation sf " +
            "inner join stagiaire_session_formation ssf on sf.session_formation_id = ssf.session_formation_id "+
            "INNER JOIN stagiaire s ON ssf.stagiaire_id = s.stagiaire_id " +
            "AND s.stagiaire_id = :id ", nativeQuery = true)
    public List<SessionFormation> getSessionByStagiaireId(@Param("id") Long id);

}
