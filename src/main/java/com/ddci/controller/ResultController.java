package com.ddci.controller;

import com.ddci.model.common.SystemResponse;
import com.ddci.model.request.ResultRequest;
import com.ddci.model.response.ResultResponse;
import com.ddci.service.ResultService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/result")
@AllArgsConstructor
public class ResultController {
    private ResultService service;

    @PostMapping("/create")
    public ResponseEntity<SystemResponse<ResultResponse>> create(@RequestBody @Valid ResultRequest resultRequest){
        return service.create(resultRequest);
    }
}
