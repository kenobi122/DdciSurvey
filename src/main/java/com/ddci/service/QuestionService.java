package com.ddci.service;

import com.ddci.model.common.SystemResponse;
import com.ddci.model.request.QuestionRequest;
import com.ddci.model.response.QuestionResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {

    ResponseEntity<SystemResponse<List<QuestionResponse>>> get(int componentIndexId);

    ResponseEntity<SystemResponse<QuestionResponse>> create(QuestionRequest request);

}
