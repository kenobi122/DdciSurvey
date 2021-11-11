package com.ddci.repository;

import com.ddci.model.entity.ResultDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResultDetailRepository extends JpaRepository<ResultDetail, Integer> {

    @Query(nativeQuery = true , value =" SELECT count(id) from ( select * from result_detail where result_id in ?1 and question_id = ?2) as T group by answer_type having answer_type = 'POSITIVE' ")
    Optional<Integer> findPositiveResult(List<Integer> resultIds, int questionId);

    @Query(nativeQuery = true , value =" SELECT count(id) from ( select * from result_detail where result_id in ?1 and question_id = ?2) as T")
    Optional<Integer> CountAllResult(List<Integer> resultIds, int questionId);

}
