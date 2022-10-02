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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String companyName;
    private String position;
    private String startDate;
    private String endDate;
    private String description;
    private String location;

}
