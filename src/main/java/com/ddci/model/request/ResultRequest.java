package com.ddci.model.request;

import lombok.Data;

import java.util.List;

@Data
public class ResultRequest {

    private int userId;

    private int departmentId;

    List<ResultDetailRequest> resultDetailRequestList;
}
