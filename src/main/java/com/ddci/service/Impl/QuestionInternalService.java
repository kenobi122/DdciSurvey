package com.ddci.service.Impl;

import com.ddci.exception.AppException;
import com.ddci.model.common.ErrorCode;
import com.ddci.model.entity.ComponentIndex;
import com.ddci.model.entity.Department;
import com.ddci.model.entity.Question;
import com.ddci.repository.ComponentIndexRepository;
import com.ddci.repository.DepartmentRepository;
import com.ddci.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionInternalService {
    private final QuestionRepository questionRepository;
    private final ComponentIndexRepository componentIndexRepository;
    private final DepartmentRepository departmentRepository;

    public List<Question> getQuestionByDepartmentId(int departmentId){
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new AppException(ErrorCode.ANSWER_NOT_FOUND) );

        List<ComponentIndex> componentIndexList = componentIndexRepository.findComponentIndexBySubjectEvaluationId(department.getSubjectEvaluationId());
        List<Integer> componentIndexIds = componentIndexList.stream().map(ComponentIndex::getId).collect(Collectors.toList());

        return questionRepository.findQuestionByComponentIndexIds(componentIndexIds);
    }

}
