package com.ddci.service.mapper;

import com.ddci.model.entity.Answer;
import com.ddci.model.request.AnswerRequest;
import com.ddci.model.response.AnswerResponse;
import org.springframework.stereotype.Component;

@Component
public class AnswerMapper {
    public Answer map(int questionId, AnswerRequest request){
        Answer  answer = new Answer();

        answer.setText(request.getText());
        answer.setChoice(request.getChoice());
        answer.setQuestionId(questionId);

        return answer;
    }

    public AnswerResponse map( Answer answer){
        AnswerResponse  answerResponse = new AnswerResponse();

        answerResponse.setId(answer.getId());
        answerResponse.setText(answer.getText());
        answerResponse.setChoice(answer.getChoice());
        answerResponse.setQuestionId(answer.getQuestionId());

        return answerResponse;
    }

}
