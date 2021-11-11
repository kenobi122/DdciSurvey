package com.ddci.service;

import com.ddci.model.common.SystemResponse;
import com.ddci.model.request.DepartmentRequest;
import com.ddci.model.response.DepartmentResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentService {
    ResponseEntity<SystemResponse<List<DepartmentResponse>>> get(int subjectEvaluationId);

    ResponseEntity<SystemResponse<DepartmentResponse>> create(DepartmentRequest request);


}
