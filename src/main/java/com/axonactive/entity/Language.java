package com.axonactive.entity;

import javax.persistence.*;

@Entity(name = "Language")
@Table(name = "language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 60)
    private String value;

    @Column(length = 5) // for example en-GB, de-CH
    private String code;
}
