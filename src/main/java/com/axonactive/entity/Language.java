package com.axonactive.entity;

import javax.persistence.*;

@Entity(name = "Language")
@Table(name = "language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String name;

    @Column(length = 5) // for example en-GB, de-CH
    private String code;
}
