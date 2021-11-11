package com.ddci.service.mapper;

import com.ddci.model.common.AnswerType;
import com.ddci.model.entity.ResultDetail;
import com.ddci.model.request.ResultDetailRequest;
import com.ddci.model.response.ResultDetailResponse;
import org.springframework.stereotype.Component;

@Component
public class ResultDetailMapper {


    public ResultDetail map(int resultId, ResultDetailRequest request){
        ResultDetail resultDetail = new ResultDetail();

        resultDetail.setResultId(resultId);
        resultDetail.setAnswerId(request.getAnswerId());
        resultDetail.setQuestionId(request.getQuestionId());
        resultDetail.setComponentIndexId(request.getComponentIndexId());
        resultDetail.setAnswerType(AnswerType.NEGATIVE);

        return resultDetail;
    }

    public ResultDetailResponse map(ResultDetail resultDetail){
        ResultDetailResponse resultDetailResponse = new ResultDetailResponse();

        resultDetailResponse.setResultId(resultDetail.getResultId());
        resultDetailResponse.setAnswerId(resultDetail.getAnswerId());
        resultDetailResponse.setQuestionId(resultDetail.getQuestionId());
        resultDetailResponse.setComponentIndexId(resultDetail.getComponentIndexId());
        resultDetailResponse.setAnswerType(resultDetail.getAnswerType());

        return resultDetailResponse;
    }
}
