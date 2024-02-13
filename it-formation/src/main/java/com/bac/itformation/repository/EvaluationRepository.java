package com.bac.itformation.repository;

import com.bac.itformation.model.EvaluationStagiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EvaluationRepository  extends JpaRepository<EvaluationStagiaire, Long> {

    @Query(value = "SELECT es.isEvaluer FROM EvaluationStagiaire es " +
            "WHERE es.sessionFormation.id = :id")
    public Optional<Boolean> isSessionEvaluer(@Param("id") Long id);


}
