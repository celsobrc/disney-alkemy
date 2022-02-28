package com.alkemy.disney.controller;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.service.GenreService;
import com.alkemy.disney.service.impl.GenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody GenreDTO genreDTO){
        GenreDTO genreSaved = genreService.save(genreDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(genreSaved);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<GenreDTO> genresDTO = genreService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(genresDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        genreService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){

        GenreDTO dto = genreService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
