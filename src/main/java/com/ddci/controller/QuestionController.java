package com.ddci.controller;

import com.ddci.model.common.SystemResponse;
import com.ddci.model.request.QuestionRequest;
import com.ddci.model.response.QuestionResponse;
import com.ddci.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/question")
@RestController
@AllArgsConstructor
public class QuestionController {
    private final QuestionService service;

    @GetMapping("/get/{componentIndexId}")
    public ResponseEntity<SystemResponse<List<QuestionResponse>>> get(@PathVariable int componentIndexId){
        return service.get(componentIndexId);
    }

    @PostMapping("/create")
    public ResponseEntity<SystemResponse<QuestionResponse>> create(@RequestBody @Valid QuestionRequest request){
        return service.create(request);
    }
}
