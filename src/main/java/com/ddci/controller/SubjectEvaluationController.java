package com.ddci.controller;

import com.ddci.model.common.SystemResponse;
import com.ddci.model.request.SubjectEvaluationRequest;
import com.ddci.model.response.SubjectEvaluationResponse;
import com.ddci.service.SubjectEvaluationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/subject-evaluation")
@AllArgsConstructor
public class SubjectEvaluationController {
    private final SubjectEvaluationService service;

    @GetMapping("/get-all")
    public ResponseEntity<SystemResponse<List<SubjectEvaluationResponse>>> getAll(){
        return service.getAll();
    }


    @PostMapping("/create")
    public ResponseEntity<SystemResponse<SubjectEvaluationResponse>> create(@RequestBody @Valid SubjectEvaluationRequest request) {
        return service.create(request);
    }


}
