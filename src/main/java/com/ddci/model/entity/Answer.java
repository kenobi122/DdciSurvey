package com.ddci.model.entity;

import com.ddci.model.common.Choice;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Accessors(chain = true)
public class Answer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String text;

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private Choice choice;

    @Column(length = 20, nullable = false)
    private int questionId;


}
