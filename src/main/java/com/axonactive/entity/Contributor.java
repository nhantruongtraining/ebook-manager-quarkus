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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ebook_id", insertable = false, updatable = false)
    private Ebook ebook;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;
}
