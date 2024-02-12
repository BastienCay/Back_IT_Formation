package com.bac.itformation.repository;

import com.bac.itformation.model.SessionFormation;
import com.bac.itformation.model.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SessionFormationRepository extends JpaRepository<SessionFormation, Long> {

    //Requête
    @Query(value = "select sf from SessionFormation sf " +
            "join sf.stagiaires s " +
            "where s.id = :idStagiaire " )
    List<SessionFormation> getSessionByStagiaireId(@Param ("idStagiaire") Long idStagiaire);

}
