package com.ddci.service.Impl;

import com.ddci.model.common.DdciInternal;
import com.ddci.model.common.PointInternal;
import com.ddci.model.common.SystemResponse;
import com.ddci.model.entity.Point;
import com.ddci.model.response.Response;
import com.ddci.repository.PointRepository;
import com.ddci.service.PointService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class PointServiceImpl implements PointService {
    private final PointRepository pointRepository;

    /**
     * calculate  sub index Points
     */
    @Override
    public void CalculateDdci() {
        List<Point> points = pointRepository.findAll();

        for (Point p : points) {
            p.setSubIndexPoint(CalPoint(p));
            pointRepository.save(p);
        }

    }

    /**
     * get Component Index Ddci Point
     * @return
     */
    @Override
    public ResponseEntity<SystemResponse<List<PointInternal>>> getAllComponentIndexDdci() {
        return Response.ok(pointRepository.findDdciComponentIndexPoint());
    }

    /**
     * get Department Ddci Point
     * @return
     */
    @Override
    public ResponseEntity<SystemResponse<List<DdciInternal>>> getDdciPoint() {
        return Response.ok(pointRepository.findDdciPoint());
    }


    private float CalPoint(Point point){
        int maxRating = pointRepository.findMaxPoint(point.getQuestionId());
        int minRating = pointRepository.findMinPoint(point.getQuestionId());

        int CurrentRating = point.getSubIndexRating();

        return (float) 9*(CurrentRating-minRating)/(maxRating-minRating)+1;
    }

}
