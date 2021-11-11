package com.ddci.service.Impl;

import com.ddci.exception.AppException;
import com.ddci.model.common.AnswerType;
import com.ddci.model.common.Choice;
import com.ddci.model.common.ErrorCode;
import com.ddci.model.entity.Answer;
import com.ddci.model.request.AnswerRequest;
import com.ddci.model.response.AnswerResponse;
import com.ddci.repository.AnswerRepository;
import com.ddci.service.AnswerService;
import com.ddci.service.mapper.AnswerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class AnswerServiceImpl implements AnswerService {
    private final AnswerMapper mapper;
    private final AnswerRepository repository;


    @Override
    public List<AnswerResponse> getByQuestionIds(List<Integer> questionIds) {
        List<Answer> answerList = repository.findAnswerByQuestionId(questionIds);

        return answerList.stream().map(mapper::map).collect(Collectors.toList());
    }

    /**
     *  create answer by question ID
     * @param questionId
     * @param answerRequestList
     * @return AnswerResponse List
     */
    @Override
    public List<AnswerResponse> create(int questionId, List<AnswerRequest> answerRequestList) {
        List<Answer> answerList = answerRequestList.stream().map(x -> mapper.map(questionId,x)).collect(Collectors.toList());
        repository.saveAll(answerList);

        return answerList.stream().map(mapper::map).collect(Collectors.toList());
    }

    @Override
    public AnswerType getAnswerType(int answerId) {
        Answer answer = repository.findById(answerId).orElseThrow(() -> new AppException(ErrorCode.ANSWER_NOT_FOUND));

        if(answer.getChoice().equals(Choice.A) || answer.getChoice().equals(Choice.B)){
            return AnswerType.POSITIVE;
        }

        return AnswerType.NEGATIVE;
    }
}
