package com.ddci.service.Impl;

import com.ddci.model.entity.ResultDetail;
import com.ddci.model.request.ResultDetailRequest;
import com.ddci.model.response.ResultDetailResponse;
import com.ddci.repository.ResultDetailRepository;
import com.ddci.service.AnswerService;
import com.ddci.service.ResultDetailService;
import com.ddci.service.ResultInternalService;
import com.ddci.service.mapper.ResultDetailMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ResultDetailServiceImpl implements ResultDetailService {
    private final ResultDetailRepository repository;
    private final ResultDetailMapper mapper;
    private final AnswerService answerService;

    /**
     * create a detail result
     * @param resultId
     * @param resultDetailRequestList
     * @return ResultDetailResponse
     */
    @Override
    public List<ResultDetailResponse> create(int resultId, List<ResultDetailRequest> resultDetailRequestList) {
        List<ResultDetail> resultDetails = resultDetailRequestList.stream().map(x
                -> mapper.map(resultId, x)).map(resultDetail
                -> resultDetail.setAnswerType(answerService.getAnswerType(resultDetail.getAnswerId()))).collect(Collectors.toList());

        repository.saveAll(resultDetails);


        return resultDetails.stream().map(mapper::map).collect(Collectors.toList());
    }
}
