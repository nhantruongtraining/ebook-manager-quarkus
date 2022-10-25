package com.axonactive.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Ebook")
@Table(name = "ebook")
public class Ebook {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(length = 254)
    private String description;

    @Column(length = 4)
    private Integer publishedYear;
}
