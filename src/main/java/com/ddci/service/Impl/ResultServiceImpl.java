package com.ddci.service.Impl;

import com.ddci.model.common.SystemResponse;
import com.ddci.model.entity.Result;
import com.ddci.model.request.ResultRequest;
import com.ddci.model.response.Response;
import com.ddci.model.response.ResultDetailResponse;
import com.ddci.model.response.ResultResponse;
import com.ddci.repository.ResultRepository;
import com.ddci.service.ResultDetailService;
import com.ddci.service.ResultInternalService;
import com.ddci.service.ResultService;
import com.ddci.service.mapper.ResultMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ResultServiceImpl implements ResultService {
    private final ResultRepository repository;
    private final ResultMapper mapper;
    private final ResultDetailService resultDetailService;
    private final ResultInternalService resultInternalService;
    private final PointServiceImpl pointService;

    /**
     * create result
     * @param resultRequest
     * @return Result Response
     */
    @Override
    public ResponseEntity<SystemResponse<ResultResponse>> create(ResultRequest resultRequest) {
        Result result = mapper.map(resultRequest);
        repository.save(result);

       List<ResultDetailResponse> resultDetailResponses =  resultDetailService.create(result.getId(), resultRequest.getResultDetailRequestList());

       // cal percent of Positive answer
       resultInternalService.Analysis(result.getDepartmentId());

       //calculate  sub index Points
       pointService.CalculateDdci();

       return Response.ok(mapper.map(result, resultDetailResponses));

    }


}
