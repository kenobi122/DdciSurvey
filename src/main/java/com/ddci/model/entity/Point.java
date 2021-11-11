package com.ddci.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Accessors(chain = true)
public class Point extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20, nullable = false)
    private int departmentId;

    @Column(length = 20, nullable = false)
    private int componentIndexId;

    @Column(length = 20, nullable = false)
    private int questionId;

    @Column(length = 20, nullable = false)
    private int subIndexRating;

    @Column(length = 20, nullable = false)
    private float SubIndexPoint;

}
