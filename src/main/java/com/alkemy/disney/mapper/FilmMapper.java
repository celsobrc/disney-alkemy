package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.FilmDTO;
import com.alkemy.disney.dto.PersonajeDTO;
import com.alkemy.disney.entity.FilmEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FilmMapper {

    @Autowired
    private PersonajeMapper personajeMapper;

    private static LocalDate string2LocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate dateFormatted = LocalDate.parse(date, formatter);
        return dateFormatted;
    }

    public FilmEntity filmDto2Entity(FilmDTO dto) {
        FilmEntity entity = new FilmEntity();
        entity.setImage(dto.getImage());
        entity.setCreationDate(string2LocalDate(dto.getCreationDate()));
        entity.setGenreId(dto.getGenreId());
        entity.setRating(dto.getRating());
        entity.setTitle(dto.getTitle());
        //entity.setCharacters();
        return entity;
    }

    public FilmDTO filmEntity2Dto(FilmEntity entity, boolean loadCharacters){
        FilmDTO dto = new FilmDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setGenreId(entity.getGenreId());
        dto.setCreationDate(entity.getCreationDate().toString());
        dto.setRating(entity.getRating());
        dto.setImage(entity.getImage());
        if (loadCharacters){
            List<PersonajeDTO> personajeDTOList = personajeMapper.EntityList2DtoList(entity.getCharacters(), false);
            dto.setCharacters(personajeDTOList);
        }
        //dto.setCharacters(entity.getCharacters());
        return dto;

    }

    public List<FilmDTO> entityList2Dtos(List<FilmEntity> films, boolean loadCharacters) {
        List<FilmDTO> dtos = new ArrayList<>();
        for (FilmEntity entity:films) {
            dtos.add(this.filmEntity2Dto(entity, loadCharacters));
        }
        return dtos;
    }
}
