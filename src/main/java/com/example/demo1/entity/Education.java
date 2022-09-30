package com.example.demo1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name="education")
@Getter
@Setter
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String school;
    private String location;
    private String degree;
    private Integer grade;
    private String field;
    private String description;
    private String start_date;
    private String end_date;

}
