package com.alkemy.disney.service;

import com.alkemy.disney.dto.PersonajeDTO;
import com.alkemy.disney.entity.PersonajeEntity;

import java.util.List;

public interface PersonajeService {

    public PersonajeDTO save(PersonajeDTO dto);
    public List<PersonajeDTO> getAll();
    public void delete(Long id);
    public List<PersonajeDTO> findByName(String name);
    List<PersonajeDTO> findByAge(Integer age);
    List<PersonajeDTO> findByMovie(Long idMovie);
}
