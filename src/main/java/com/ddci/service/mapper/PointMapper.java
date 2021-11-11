package com.ddci.service.mapper;

import com.ddci.model.entity.Point;
import org.springframework.stereotype.Component;

@Component
public class PointMapper {
    public Point map(Point point, int departmentId, int componentIndexId, int questionId, int subIndexPoint){

        point.setDepartmentId(departmentId);
        point.setComponentIndexId(componentIndexId);
        point.setQuestionId(questionId);
        point.setSubIndexPoint(subIndexPoint);

        return point;
    }
}
