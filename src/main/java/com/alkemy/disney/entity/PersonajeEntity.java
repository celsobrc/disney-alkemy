package com.alkemy.disney.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personaje")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@SQLDelete(sql = "UPDATE personaje SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class PersonajeEntity extends BaseEntity{

    private String name;
    private String image;
    private Integer age;
    private Integer weight; //in grams
    private String history;
    @ManyToMany(mappedBy = "characters", cascade = CascadeType.ALL)
    private List<FilmEntity> films = new ArrayList<>();
    private boolean deleted = Boolean.FALSE;

}
