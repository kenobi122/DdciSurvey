package com.ddci.model.response;

import com.ddci.model.common.AnswerType;
import lombok.Data;
@Data
public class ResultDetailResponse {
    private int resultId;

    private int componentIndexId;

    private int questionId;

    private int answerId;

    private AnswerType answerType;
}
