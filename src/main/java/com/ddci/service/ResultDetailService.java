package com.ddci.service;

import com.ddci.model.request.ResultDetailRequest;
import com.ddci.model.response.ResultDetailResponse;

import java.util.List;

public interface ResultDetailService {
    List<ResultDetailResponse> create(int resultId, List<ResultDetailRequest> resultDetailRequestList);
}
