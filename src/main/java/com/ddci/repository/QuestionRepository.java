package com.ddci.repository;

import com.ddci.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findQuestionByComponentIndexId(int componentIndexId);

    @Query("select q from Question q where q.componentIndexId in :ids ")
    List<Question> findQuestionByComponentIndexIds(@Param("ids") List<Integer> componentIndexIds);
}
