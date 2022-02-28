package com.alkemy.disney.service;

import com.alkemy.disney.dto.FilmDTO;

import java.util.List;

public interface FilmService {

    public FilmDTO save(FilmDTO dto);

    public List<FilmDTO> getAll();

    public void delete(Long id);

    List<FilmDTO> getByFilters(String title, String genreId, String order);


}
