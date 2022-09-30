package com.example.demo1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="experience")
@Getter
@Setter
public class Experience{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String company_name;
    private String position;
    private String start_date;
    private String end_date;
    private String description;
    private String location;

}
