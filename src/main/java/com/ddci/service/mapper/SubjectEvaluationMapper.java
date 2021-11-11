package com.ddci.service.mapper;

import com.ddci.model.entity.SubjectEvaluation;
import com.ddci.model.request.SubjectEvaluationRequest;
import com.ddci.model.response.SubjectEvaluationResponse;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
public class SubjectEvaluationMapper {
    public SubjectEvaluation map(SubjectEvaluationRequest request){
        SubjectEvaluation subjectEvaluation = new SubjectEvaluation();

        subjectEvaluation.setName(request.getName());

        return subjectEvaluation;
    }

    public SubjectEvaluationResponse map(SubjectEvaluation subjectEvaluation){
        SubjectEvaluationResponse subjectEvaluationResponse = new SubjectEvaluationResponse();

        subjectEvaluationResponse.setId(subjectEvaluation.getId());
        subjectEvaluationResponse.setName(subjectEvaluation.getName());

        return subjectEvaluationResponse;
    }

}
