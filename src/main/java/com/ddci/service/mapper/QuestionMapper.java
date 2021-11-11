package com.ddci.service.mapper;

import com.ddci.model.entity.Question;
import com.ddci.model.request.QuestionRequest;
import com.ddci.model.response.AnswerResponse;
import com.ddci.model.response.QuestionResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionMapper {
    public Question map(QuestionRequest request){
        Question question = new Question();

        question.setText(request.getText());
        question.setComponentIndexId(request.getComponentIndexId());

        return question;
    }

    public QuestionResponse map(Question question, List<AnswerResponse> answerResponseList){
        QuestionResponse questionResponse = new QuestionResponse();

        questionResponse.setId(question.getId());
        questionResponse.setText(question.getText());
        questionResponse.setComponentIndexId(question.getComponentIndexId());
        questionResponse.setAnswerResponseList(answerResponseList);

        return questionResponse;
    }
}
