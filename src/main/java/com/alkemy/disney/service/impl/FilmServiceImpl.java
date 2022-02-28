package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.FilmDTO;
import com.alkemy.disney.dto.FilmFiltersDTO;
import com.alkemy.disney.entity.FilmEntity;
import com.alkemy.disney.mapper.FilmMapper;
import com.alkemy.disney.repository.FilmRepository;
import com.alkemy.disney.repository.specifications.FilmSpecification;
import com.alkemy.disney.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private FilmMapper filmMapper;
    @Autowired
    private FilmSpecification filmSpecification;


    @Override
    @Transactional
    public FilmDTO save(FilmDTO dto) {
        FilmEntity entity = filmMapper.filmDto2Entity(dto);
        FilmEntity entitySaved = filmRepository.save(entity);
        FilmDTO result = filmMapper.filmEntity2Dto(entity, false);

        return null;
    }

    @Override
    @Transactional
    public List<FilmDTO> getAll() {
        List<FilmEntity> entities = filmRepository.findAll();
        List<FilmDTO> dtos = new ArrayList<>();
        dtos = filmMapper.entityList2Dtos(entities, true);
        return dtos;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        filmRepository.deleteById(id);
    }

    @Override
    public List<FilmDTO> getByFilters(String title, String genreId, String order) {
        FilmFiltersDTO filmIconsDTO = new FilmFiltersDTO(title, genreId, order);
        List<FilmEntity> entities = filmRepository.findAll(filmSpecification.getByFilters(filmIconsDTO));
        List<FilmDTO> results = filmMapper.entityList2Dtos(entities, true);
        return results;
    }
}
