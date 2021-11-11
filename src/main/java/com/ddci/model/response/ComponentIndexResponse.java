package com.ddci.model.response;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ComponentIndexResponse {
    private int id;

    private String name;

    private int subjectEvaluationId;
}
