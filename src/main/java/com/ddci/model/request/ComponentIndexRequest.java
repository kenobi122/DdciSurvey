package com.ddci.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ComponentIndexRequest {
    @NotBlank
    private String name;

    private int subjectEvaluationId;
}
