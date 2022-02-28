package com.alkemy.disney.controller;

import com.alkemy.disney.dto.FilmDTO;
import com.alkemy.disney.entity.FilmEntity;
import com.alkemy.disney.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("films")
public class FilmController {

    @Autowired
    private FilmService filmService;


    @PostMapping
    public ResponseEntity<?> save(@RequestBody FilmDTO dto){
        filmService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("films")
    public ResponseEntity<?> getAll(){
        List<FilmDTO> dtos = filmService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        filmService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<?> getDetailsByFilters(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String genreId,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ){
        List<FilmDTO> films = filmService.getByFilters(title, genreId, order);
        return ResponseEntity.status(HttpStatus.OK).body(films);
    }

}


