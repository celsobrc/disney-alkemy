package com.alkemy.disney.service;

import com.alkemy.disney.dto.GenreDTO;

import java.util.List;

public interface GenreService {

    public GenreDTO save(GenreDTO dto);
    public List<GenreDTO> getAll();
    public void delete(Long id);
    GenreDTO getById(Long id);
}
