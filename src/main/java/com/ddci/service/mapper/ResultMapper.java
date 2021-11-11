package com.ddci.service.mapper;

import com.ddci.model.entity.Result;
import com.ddci.model.request.ResultRequest;
import com.ddci.model.response.ResultDetailResponse;
import com.ddci.model.response.ResultResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResultMapper {
    public Result map(ResultRequest resultRequest) {
        Result result = new Result();

        result.setDepartmentId(resultRequest.getDepartmentId());
        result.setUserId(resultRequest.getUserId());

        return result;
    }

    public ResultResponse map(Result result, List<ResultDetailResponse> resultDetailResponses) {
        ResultResponse resultResponse = new ResultResponse();

        resultResponse.setId(result.getId());
        resultResponse.setDepartmentId(result.getDepartmentId());
        resultResponse.setUserId(result.getUserId());
        resultResponse.setResultDetailResponses(resultDetailResponses);

        return resultResponse;
    }
}
