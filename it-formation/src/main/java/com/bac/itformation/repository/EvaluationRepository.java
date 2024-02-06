package com.bac.itformation.repository;

import com.bac.itformation.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository  extends JpaRepository<Evaluation, Long> {
}
