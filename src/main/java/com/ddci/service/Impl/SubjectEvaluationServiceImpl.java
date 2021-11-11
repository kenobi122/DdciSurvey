package com.ddci.service.Impl;

import com.ddci.model.common.SystemResponse;
import com.ddci.model.entity.SubjectEvaluation;
import com.ddci.model.request.SubjectEvaluationRequest;
import com.ddci.model.response.Response;
import com.ddci.model.response.SubjectEvaluationResponse;
import com.ddci.repository.SubjectEvaluationRepository;
import com.ddci.service.SubjectEvaluationService;
import com.ddci.service.mapper.SubjectEvaluationMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubjectEvaluationServiceImpl implements SubjectEvaluationService {
    private final SubjectEvaluationRepository repository;
    private final SubjectEvaluationMapper mapper;

    @Override
    public ResponseEntity<SystemResponse<List<SubjectEvaluationResponse>>> getAll() {
        List<SubjectEvaluation> subjectEvaluations = repository.findAll();

        List<SubjectEvaluationResponse> subjectEvaluationResponses = subjectEvaluations.stream().map(mapper::map).collect(Collectors.toList());

        return Response.ok(subjectEvaluationResponses);
    }

    @Override
    public ResponseEntity<SystemResponse<SubjectEvaluationResponse>> create(SubjectEvaluationRequest request) {
        SubjectEvaluation subjectEvaluation = mapper.map(request);

        repository.save(subjectEvaluation);

        return Response.ok(mapper.map(subjectEvaluation));
    }


}
