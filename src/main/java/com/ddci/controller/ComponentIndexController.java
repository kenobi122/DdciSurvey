package com.ddci.controller;

import com.ddci.model.common.SystemResponse;
import com.ddci.model.request.ComponentIndexRequest;
import com.ddci.model.response.ComponentIndexResponse;
import com.ddci.service.ComponentIndexService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/component-index")
@AllArgsConstructor
public class ComponentIndexController {
    private final ComponentIndexService service;

    @GetMapping("/get/{subjectEvaluationId}")
    public ResponseEntity<SystemResponse<List<ComponentIndexResponse>>> get(@PathVariable int subjectEvaluationId){
        return service.get(subjectEvaluationId);
    }

    @PostMapping("/create")
    public ResponseEntity<SystemResponse<ComponentIndexResponse>> create(@RequestBody @Valid ComponentIndexRequest request){
        return service.create(request);
    }
}
