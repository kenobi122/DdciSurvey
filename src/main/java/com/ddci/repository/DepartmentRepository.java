package com.ddci.repository;

import com.ddci.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

    List<Department> findDepartmentBySubjectEvaluationId(int subjectEvaluationId);

    @Query("select r.id from Department r where r.subjectEvaluationId =?1 ")
    List<Integer> findIdBySubjectEvaluationId(int subjectEvaluationId);
}
