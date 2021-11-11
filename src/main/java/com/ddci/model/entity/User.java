package com.ddci.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Accessors(chain = true)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int id;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String account;

    @Column(columnDefinition = "varchar(80)", nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String userType;
}
