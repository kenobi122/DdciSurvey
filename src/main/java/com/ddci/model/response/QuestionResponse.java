package com.ddci.model.response;

import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
public class QuestionResponse {
    private int id;

    private String text;

    private int componentIndexId;

    private List<AnswerResponse> answerResponseList;
}
