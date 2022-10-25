package com.axonactive.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "Ebook")
@Table(name = "ebook")
@NamedQuery(
        name = "Ebooks.findAll",
        query = "SELECT e FROM Ebook e ORDER BY e.title"
)
public class Ebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String uuid;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(length = 254)
    private String description;

    @Column(name = "published_year", length = 4)
    private Integer publishedYear;

    @Column(name = "creation_date")
    private LocalDate creationDate;

//    @Column
//    private Boolean favorite;
//
//    @Enumerated(EnumType.STRING)
//    private EbookStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id")
    private Language language;

    @OneToMany(mappedBy = "ebook")
    private List<Contributor> contributors;

}
