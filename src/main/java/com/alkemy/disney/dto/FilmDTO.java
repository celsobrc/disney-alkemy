package com.alkemy.disney.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class FilmDTO {

    private Long id;
    private String title;
    private String image;
    private String creationDate;
    private Integer rating;
    private Long genreId;
    private List<PersonajeDTO> characters = new ArrayList<>();


}
