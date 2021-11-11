package com.ddci.model.response;

import lombok.Data;

import java.util.List;

@Data
public class ResultResponse {
    private int id;

    private int userId;

    private int departmentId;

    List<ResultDetailResponse> resultDetailResponses;

}
