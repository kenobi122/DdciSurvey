package com.ddci.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Accessors(chain = true)
public class Question extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 300, nullable = false)
    private String text;

    @Column(length = 10, nullable = false)
    private int componentIndexId;
}
