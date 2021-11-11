package com.ddci.service;

import com.ddci.model.common.SystemResponse;
import com.ddci.model.request.ComponentIndexRequest;
import com.ddci.model.response.ComponentIndexResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ComponentIndexService {

    ResponseEntity<SystemResponse<List<ComponentIndexResponse>>> get(int subjectEvaluationId);

    ResponseEntity<SystemResponse<ComponentIndexResponse>> create(ComponentIndexRequest request);

}
