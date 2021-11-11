package com.ddci.model.response;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DepartmentResponse {
    private int id;

    private String name;


    private int subjectEvaluationId;
}
