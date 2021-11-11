package com.ddci.service;

import com.ddci.model.common.SystemResponse;
import com.ddci.model.request.SubjectEvaluationRequest;
import com.ddci.model.response.SubjectEvaluationResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubjectEvaluationService {
    ResponseEntity<SystemResponse<SubjectEvaluationResponse>> create(SubjectEvaluationRequest request);

    ResponseEntity<SystemResponse<List<SubjectEvaluationResponse>>> getAll();
}
