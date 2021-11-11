package com.ddci.service.mapper;

import com.ddci.model.entity.ComponentIndex;
import com.ddci.model.request.ComponentIndexRequest;
import com.ddci.model.response.ComponentIndexResponse;
import org.springframework.stereotype.Component;

@Component
public class ComponentIndexMapper {
    public ComponentIndex map(ComponentIndexRequest request){
        ComponentIndex componentIndex = new ComponentIndex();

        componentIndex.setName(request.getName());
        componentIndex.setSubjectEvaluationId(request.getSubjectEvaluationId());

        return componentIndex;
    }

    public ComponentIndexResponse map(ComponentIndex componentIndex){
        ComponentIndexResponse componentIndexResponse = new ComponentIndexResponse();

        componentIndexResponse.setId(componentIndex.getId());
        componentIndexResponse.setName(componentIndex.getName());
        componentIndexResponse.setSubjectEvaluationId(componentIndex.getSubjectEvaluationId());

        return componentIndexResponse;
    }


}
