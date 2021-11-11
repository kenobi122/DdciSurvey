package com.ddci.service;

import com.ddci.model.common.DdciInternal;
import com.ddci.model.common.PointInternal;
import com.ddci.model.common.SystemResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PointService {

     void CalculateDdci();

     ResponseEntity<SystemResponse<List<PointInternal>>> getAllComponentIndexDdci();

    ResponseEntity<SystemResponse<List<DdciInternal>>> getDdciPoint();
}
