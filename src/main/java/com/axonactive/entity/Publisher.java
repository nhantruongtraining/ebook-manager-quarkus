package com.axonactive.entity;

import javax.persistence.*;

@Entity(name = "Publisher")
@Table(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 60)
    private String value;

    @Column
    private String location;

    @Column
    private String url;
}
