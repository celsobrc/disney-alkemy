package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.PersonajeDTO;
import com.alkemy.disney.entity.PersonajeEntity;
import com.alkemy.disney.mapper.PersonajeMapper;
import com.alkemy.disney.repository.PersonajeRepository;
import com.alkemy.disney.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;
    @Autowired
    private PersonajeMapper personajeMapper;

    @Override
    @Transactional
    public PersonajeDTO save(PersonajeDTO dto) {
        PersonajeEntity entity = personajeMapper.characterDto2Entity(dto);
        PersonajeEntity entitySaved = personajeRepository.save(entity);
        return personajeMapper.characterEntity2Dto(entitySaved, false);
    }

    @Override
    @Transactional
    public List<PersonajeDTO> getAll() {
        List<PersonajeEntity> entities = personajeRepository.findAll();
        List<PersonajeDTO> dtos = new ArrayList<>();
        for (PersonajeEntity entity: entities) {
            dtos.add(personajeMapper.characterEntity2Dto(entity, false));
        }
        return dtos;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        personajeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<PersonajeDTO> findByName(String name) {
        List<PersonajeEntity> entities = personajeRepository.findByName(name);
        List<PersonajeDTO> dtos = personajeMapper.EntityList2DtoList(entities, false);
        return dtos;
    }

    @Override
    @Transactional
    public List<PersonajeDTO> findByAge(Integer age) {
        List<PersonajeEntity> entities = personajeRepository.findByAge(age);
        List<PersonajeDTO> dtos = personajeMapper.EntityList2DtoList(entities, false);
        return dtos;
    }

    @Override
    @Transactional
    public List<PersonajeDTO> findByMovie(Long idMovie) {
        List<PersonajeEntity> entities = personajeRepository.findALLByFilmsId(idMovie);
        List<PersonajeDTO> dtos = personajeMapper.EntityList2DtoList(entities, false);
        return dtos;
    }
}
