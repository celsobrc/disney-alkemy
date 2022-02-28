package com.alkemy.disney.dto;

import com.alkemy.disney.entity.FilmEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PersonajeDTO {

    private Long id;
    private String name;
    private String image;
    private Integer weight; //gramos
    private Integer age;
    private String history;
    private List<FilmDTO> films = new ArrayList<>();

}
