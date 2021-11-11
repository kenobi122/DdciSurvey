package com.ddci.service;

import com.ddci.model.common.SystemResponse;
import com.ddci.model.request.ResultRequest;
import com.ddci.model.response.ResultResponse;
import org.springframework.http.ResponseEntity;

public interface ResultService {
    ResponseEntity<SystemResponse<ResultResponse>> create(ResultRequest resultRequest);
}
