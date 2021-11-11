package com.ddci.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Accessors(chain = true)
public class SubjectEvaluation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String name;
}
