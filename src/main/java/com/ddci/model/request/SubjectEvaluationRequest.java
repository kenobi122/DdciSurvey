package com.ddci.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SubjectEvaluationRequest {
    @NotBlank
    String name;
}
