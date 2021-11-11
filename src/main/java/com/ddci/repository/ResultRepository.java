package com.ddci.repository;

import com.ddci.model.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
    @Query("select r from Result r where r.departmentId in: ids ")
    List<Result> findResultByDepartmentId(@Param("ids") List<Integer> departmentId);

    @Query("select r from Result r where r.departmentId = ?1 ")
    List<Result> findbyDepartmentId(Integer departmentId);
}
