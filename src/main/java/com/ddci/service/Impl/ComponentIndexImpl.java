package com.ddci.service.Impl;

import com.ddci.model.common.SystemResponse;
import com.ddci.model.entity.ComponentIndex;
import com.ddci.model.request.ComponentIndexRequest;
import com.ddci.model.response.ComponentIndexResponse;
import com.ddci.model.response.Response;
import com.ddci.repository.ComponentIndexRepository;
import com.ddci.service.ComponentIndexService;
import com.ddci.service.mapper.ComponentIndexMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ComponentIndexImpl implements ComponentIndexService {
    private final ComponentIndexRepository repository;
    private final ComponentIndexMapper mapper;


    @Override
    public ResponseEntity<SystemResponse<List<ComponentIndexResponse>>> get(int subjectEvaluationId) {
        List<ComponentIndex> componentIndexList = repository.findComponentIndexBySubjectEvaluationId(subjectEvaluationId);
        List<ComponentIndexResponse> componentIndexResponses = componentIndexList.stream().map(mapper::map).collect(Collectors.toList());

        return Response.ok(componentIndexResponses);
    }

    /**
     * create Component Index , ex "tinh minh bach.."
     * @param request
     * @return Component Index Response
     */
    @Override
    public ResponseEntity<SystemResponse<ComponentIndexResponse>> create(ComponentIndexRequest request) {
        ComponentIndex componentIndex = mapper.map(request);

        repository.save(componentIndex);

        return Response.ok(mapper.map(componentIndex));
    }
}
