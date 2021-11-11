package com.ddci.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class QuestionRequest {
    @NotBlank
    private String text;

    private int componentIndexId;

    private List<AnswerRequest> answerRequestList;
}
