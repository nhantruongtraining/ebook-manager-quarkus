package com.axonactive.entity;

import javax.persistence.*;

@Entity(name = "Category")
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String topic;

    @Column(length = 50)
    private String subtopic;


}
