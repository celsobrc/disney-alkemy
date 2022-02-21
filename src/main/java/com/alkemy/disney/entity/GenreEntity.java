package com.alkemy.disney.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class GenreEntity extends BaseEntity{

    private String name;

    private String image;

}
