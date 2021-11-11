package com.ddci.model.entity;

import com.ddci.model.common.AnswerType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Accessors(chain = true)
public class ResultDetail extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int id;

    @Column(length = 10, nullable = false)
    private int resultId;

    @Column(length = 10, nullable = false)
    private int componentIndexId;

    @Column(length = 10, nullable = false)
    private int questionId;

    @Column(length = 10, nullable = false)
    private int answerId;

    @Enumerated(EnumType.STRING)
    private AnswerType answerType;
}
