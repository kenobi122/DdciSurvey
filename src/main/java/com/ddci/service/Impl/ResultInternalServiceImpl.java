package com.ddci.service.Impl;

import com.ddci.model.entity.Point;
import com.ddci.model.entity.Question;
import com.ddci.model.entity.Result;
import com.ddci.repository.PointRepository;
import com.ddci.repository.ResultDetailRepository;
import com.ddci.repository.ResultRepository;
import com.ddci.service.ResultInternalService;
import com.ddci.service.mapper.PointMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ResultInternalServiceImpl implements ResultInternalService {
    private final ResultRepository resultRepository;
    private final ResultDetailRepository resultDetailRepository;
    private final PointRepository pointRepository;
    private final QuestionInternalService questionInternalService;
    private final PointMapper pointMapper;

    @Override
    public void Analysis(int departmentId){

        List<Question> questionList = questionInternalService.getQuestionByDepartmentId(departmentId);

        calculatorByQuestion(departmentId, questionList);
    }

    private void calculatorByQuestion(Integer departmentId, List<Question> questionList){
        questionList.forEach(x -> calculatorResult(departmentId,x.getComponentIndexId(), x.getId()));
    }

    private void calculatorResult(int departmentId, int componentIndexId, int questionId) {
            List<Result> resultList = resultRepository.findbyDepartmentId(departmentId);
            List<Integer> resultIds = resultList.stream().map(Result::getId).collect(Collectors.toList());

            int positiveCount = resultDetailRepository.findPositiveResult(resultIds, questionId).orElse(0);
            int allCount = resultDetailRepository.CountAllResult(resultIds, questionId).orElse(0);

            int subIndexPoint = positiveCount*100/allCount;

            Point point = pointRepository.findPointByDepartmentIdIdAndAndQuestionId(departmentId,questionId).orElse(new Point());

        pointRepository.save(pointMapper.map(point, departmentId, componentIndexId, questionId, subIndexPoint));
    }

}
