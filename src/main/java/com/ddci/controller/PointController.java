package com.ddci.controller;

import com.ddci.model.common.DdciInternal;
import com.ddci.model.common.PointInternal;
import com.ddci.model.common.SystemResponse;
import com.ddci.service.PointService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/point")
@AllArgsConstructor
public class PointController {
    private final PointService pointService;

    @GetMapping("/get-componentIndex-ddci")
    public ResponseEntity<SystemResponse<List<PointInternal>>> getALlDdci(){
        return pointService.getAllComponentIndexDdci();
    }

    @GetMapping("/get-ddci")
    public ResponseEntity<SystemResponse<List<DdciInternal>>> getDdciPoint(){
        return pointService.getDdciPoint();
    }
}
