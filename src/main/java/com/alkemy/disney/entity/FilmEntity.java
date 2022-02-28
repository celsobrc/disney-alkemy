package com.alkemy.disney.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "film")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE film SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class FilmEntity extends BaseEntity {

    private String title;

    private String image;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate creationDate;

    private Integer rating;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE}
    )
    @JoinColumn(name = "genre_id", insertable = false, updatable = false)
    private GenreEntity genre;

    @Column(name = "genre_id", nullable = false)
    private Long genreId;

    @ManyToMany
            (
                    cascade = {
                            CascadeType.PERSIST,
                            CascadeType.MERGE
                    })
    @JoinTable(
            name = "film_character",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id"))
    private List<PersonajeEntity> characters = new ArrayList<>();

    private boolean deleted = Boolean.FALSE;

}
