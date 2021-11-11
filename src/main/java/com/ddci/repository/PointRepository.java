package com.ddci.repository;

import com.ddci.model.common.DdciInternal;
import com.ddci.model.common.PointInternal;
import com.ddci.model.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PointRepository extends JpaRepository<Point, Integer> {
    List<Point> findAllByDepartmentId(int departmentId);

    @Query(nativeQuery = true, value = "select max(sub_index_point) from point where question_id = ?1")
    Integer findMaxPoint(int questionId);

    @Query(nativeQuery = true, value = "select min(sub_index_point) from point where question_id = ?1")
    Integer findMinPoint(int questionId);


    @Query("select p from Point p where p.componentIndexId = ?1 and p.departmentId =?2")
    List<Point> findPointByComponentIndexIdAndAndDeparmentId(int componentId, int departmentId);

    @Query("select p from Point p where p.departmentId = ?1 and p.questionId =?2")
    Optional<Point> findPointByDepartmentIdIdAndAndQuestionId(int departmentId, int questionId);

    @Query(nativeQuery = true, value = "SELECT (SUM(sub_index_point)/2) as ComponentIndexPoint " +
            ",component_index_id as componentIndexId,department_id as departmentId " +
            "FROM ddci.point group by department_id,component_index_id;")
    List<PointInternal> findDdciComponentIndexPoint();

    @Query(nativeQuery = true, value = "select sum(ComponentIndexPoint)/10 as DdciPoint , " +
            "department_id as departmentId from (SELECT (SUM(sub_index_point)/2) as" +
            " ComponentIndexPoint ,component_index_id,department_id FROM ddci.point " +
            "group by department_id,component_index_id) as T group by department_id order by DdciPoint DESC;")
    List<DdciInternal> findDdciPoint();
}
