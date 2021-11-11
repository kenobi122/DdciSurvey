package com.ddci.service.Impl;

import com.ddci.model.common.SystemResponse;
import com.ddci.model.entity.Question;
import com.ddci.model.request.QuestionRequest;
import com.ddci.model.response.AnswerResponse;
import com.ddci.model.response.QuestionResponse;
import com.ddci.model.response.Response;
import com.ddci.repository.QuestionRepository;
import com.ddci.service.AnswerService;
import com.ddci.service.QuestionService;
import com.ddci.service.mapper.QuestionMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository repository;
    private final QuestionMapper mapper;
    private final AnswerService answerService;

    @Override
    public ResponseEntity<SystemResponse<List<QuestionResponse>>> get(int componentIndexId) {
        // find all question  by component index
        List<Question> questionList = repository.findQuestionByComponentIndexId(componentIndexId);
        // get list id from list of question
        List<Integer> questionIds = questionList.stream().map(Question::getId).collect(Collectors.toList());
        //get all answer by list of question id
        List<AnswerResponse> answerResponseList = answerService.getByQuestionIds(questionIds);
        // map question and answer by their relations
        List<QuestionResponse> questionResponses = questionList.stream().map( x ->
                mapper.map(x,answerResponseList.stream().filter(i
                        -> x.getId()==i.getQuestionId()).collect(Collectors.toList()) ) ).collect(Collectors.toList());

        return Response.ok(questionResponses);
    }

    @Override
    public ResponseEntity<SystemResponse<QuestionResponse>> create(QuestionRequest request) {
        Question question = mapper.map(request);
        repository.save(question);

        List<AnswerResponse> answerResponseList = answerService.create(question.getId(), request.getAnswerRequestList());

        return Response.ok(mapper.map(question, answerResponseList));
    }
}
