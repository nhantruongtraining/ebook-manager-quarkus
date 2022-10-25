package com.axonactive.entity;

import javax.persistence.*;

@Entity(name = "Contributor")
@Table(name = "contributor")
public class Contributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ContributorType type;
}
