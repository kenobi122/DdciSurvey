package com.ddci.model.response;

import com.ddci.model.common.Choice;
import lombok.Data;

@Data
public class AnswerResponse {
    private int id;

    private String text;


    private Choice choice;


    private int questionId;
}
