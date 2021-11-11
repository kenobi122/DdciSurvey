package com.ddci.service.Impl;

import com.ddci.model.common.SystemResponse;
import com.ddci.model.entity.Department;
import com.ddci.model.request.DepartmentRequest;
import com.ddci.model.response.DepartmentResponse;
import com.ddci.model.response.Response;
import com.ddci.repository.DepartmentRepository;
import com.ddci.service.DepartmentService;
import com.ddci.service.mapper.DepartmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentMapper mapper;
    private final DepartmentRepository repository;

    /**
     * get Department by Suject Evaluation
     * @param subjectEvaluationId
     * @return Department Response
     */
    @Override
    public ResponseEntity<SystemResponse<List<DepartmentResponse>>> get(int subjectEvaluationId) {
        List<Department> departments = repository.findDepartmentBySubjectEvaluationId(subjectEvaluationId);

        List<DepartmentResponse> departmentResponses = departments.stream().map(mapper::map).collect(Collectors.toList());

        return Response.ok(departmentResponses);
    }

    /**
     * create department , ex "huyen chiem hoa.."
     * @param request
     * @return Department Response
     */
    @Override
    public ResponseEntity<SystemResponse<DepartmentResponse>> create(DepartmentRequest request) {
        Department department = mapper.map(request);

        repository.save(department);

        return Response.ok(mapper.map(department));
    }
}
