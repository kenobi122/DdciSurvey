package com.ddci.service;

import com.ddci.model.common.AnswerType;
import com.ddci.model.request.AnswerRequest;
import com.ddci.model.response.AnswerResponse;

import java.util.List;

public interface AnswerService {
    List<AnswerResponse> getByQuestionIds(List<Integer> questionIds);
    List<AnswerResponse> create(int questionId, List<AnswerRequest> answerRequestList);
    AnswerType getAnswerType(int answerId);
}
