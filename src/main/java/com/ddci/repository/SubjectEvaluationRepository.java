package com.ddci.repository;

import com.ddci.model.entity.SubjectEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectEvaluationRepository extends JpaRepository<SubjectEvaluation, Integer> {
}
