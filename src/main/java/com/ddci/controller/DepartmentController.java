package com.ddci.controller;

import com.ddci.model.common.SystemResponse;
import com.ddci.model.request.DepartmentRequest;
import com.ddci.model.response.DepartmentResponse;
import com.ddci.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("department")
@AllArgsConstructor
public class DepartmentController {
    private final DepartmentService service;


    @GetMapping("/get/{subjectEvaluationId}")
    public ResponseEntity<SystemResponse<List<DepartmentResponse>>> get(@PathVariable int subjectEvaluationId){
        return service.get(subjectEvaluationId);
    }

    @PostMapping("/create")
    public ResponseEntity<SystemResponse<DepartmentResponse>> create(@RequestBody @Valid DepartmentRequest request){

        return service.create(request);
    }
}
