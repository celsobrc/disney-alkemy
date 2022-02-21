package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.entity.GenreEntity;
import com.alkemy.disney.mapper.GenreMapper;
import com.alkemy.disney.repository.GenreRepository;
import com.alkemy.disney.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
}

