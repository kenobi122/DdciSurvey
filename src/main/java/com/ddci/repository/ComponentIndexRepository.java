package com.ddci.repository;

import com.ddci.model.entity.ComponentIndex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponentIndexRepository extends JpaRepository<ComponentIndex, Integer> {
    List<ComponentIndex> findComponentIndexBySubjectEvaluationId(int subjectEvaluationId);
}
