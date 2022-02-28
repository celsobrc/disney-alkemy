package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.FilmDTO;
import com.alkemy.disney.dto.PersonajeDTO;
import com.alkemy.disney.entity.PersonajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonajeMapper {

    @Autowired
    private FilmMapper filmMapper;

    public PersonajeEntity characterDto2Entity(PersonajeDTO dto){
        PersonajeEntity entity = new PersonajeEntity();
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        entity.setWeight(dto.getWeight());
        entity.setAge(dto.getAge());
        entity.setHistory(dto.getHistory());
        return entity;
    }

    public PersonajeDTO characterEntity2Dto(PersonajeEntity entity, boolean loadFilms){
        PersonajeDTO dto = new PersonajeDTO();
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setHistory(entity.getHistory());
        dto.setWeight(entity.getWeight());
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        if (loadFilms){
            List<FilmDTO> filmDTOS = filmMapper.entityList2Dtos(entity.getFilms(), false);
            dto.setFilms(filmDTOS);
        }

        return dto;
    }

    public List<PersonajeDTO> EntityList2DtoList(List<PersonajeEntity> characters, boolean loadFilms) {
        List<PersonajeDTO> dtos = new ArrayList<>();
        for (PersonajeEntity entity: characters) {
            dtos.add(this.characterEntity2Dto(entity, loadFilms));
        }
        return dtos;
    }
}
