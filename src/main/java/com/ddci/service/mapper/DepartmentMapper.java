package com.ddci.service.mapper;

import com.ddci.model.entity.Department;
import com.ddci.model.request.DepartmentRequest;
import com.ddci.model.response.DepartmentResponse;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

    public Department map(DepartmentRequest request){
        Department department = new Department();

        department.setName(request.getName());
        department.setSubjectEvaluationId(request.getSubjectEvaluationId());

        return department;
    }

    public DepartmentResponse map(Department department){
        DepartmentResponse departmentResponse = new DepartmentResponse();

        departmentResponse.setId(department.getId());
        departmentResponse.setName(department.getName());
        departmentResponse.setSubjectEvaluationId(department.getSubjectEvaluationId());

        return departmentResponse;

    }

}

