package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.entity.GenreEntity;
import com.alkemy.disney.exception.ParamNotFound;
import com.alkemy.disney.mapper.GenreMapper;
import com.alkemy.disney.repository.GenreRepository;
import com.alkemy.disney.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreMapper genreMapper;
    @Autowired
    private GenreRepository genreRepository;

    @Transactional
    public GenreDTO save(GenreDTO dto){
        GenreEntity genreEntity = genreMapper.genreDto2GenreEntity(dto);
        GenreEntity genreSaved = genreRepository.save(genreEntity);
        GenreDTO genreDTO = genreMapper.genreEntity2GenreDto(genreSaved);
        return genreDTO;
    }

    @Override
    @Transactional
    public List<GenreDTO> getAll() {
        List<GenreEntity> entities = genreRepository.findAll();
        List<GenreDTO> result = genreMapper.genreEntityList2DtoGenreList(entities);
        return result;
    }

    @Override
    public void delete(Long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public GenreDTO getById(Long id) {
        Optional<GenreEntity> entity = genreRepository.findById(id);
        if (!entity.isPresent()){
            throw new ParamNotFound("Genre id invalid");
        }
        GenreDTO dto = genreMapper.genreEntity2GenreDto(entity.get());
        return dto;
    }
}

