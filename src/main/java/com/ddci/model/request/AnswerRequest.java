package com.ddci.model.request;

import com.ddci.model.common.Choice;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AnswerRequest {
    @NotBlank
    private String text;
    @NotBlank
    private Choice choice;


}
