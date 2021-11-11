package com.ddci.repository;

import com.ddci.model.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    @Query(value = "select a from Answer a where a.questionId in :ids ")
    List<Answer> findAnswerByQuestionId(@Param("ids") List<Integer> questiondIds);

}
