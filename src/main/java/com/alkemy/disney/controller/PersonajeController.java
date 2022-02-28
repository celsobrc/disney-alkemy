package com.alkemy.disney.controller;

import com.alkemy.disney.dto.PersonajeDTO;
import com.alkemy.disney.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("characters")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PersonajeDTO personajeDTO){
        PersonajeDTO personajeDTOSaved = personajeService.save(personajeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeDTOSaved);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<PersonajeDTO> personajes = personajeService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(personajes);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        personajeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(params = "name")
    public ResponseEntity<?> findByName(@RequestParam String name){
        List<PersonajeDTO> dtos = personajeService.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @GetMapping(params = "age")
    public ResponseEntity<?> findByAge(@RequestParam Integer age){
        List<PersonajeDTO> dtos = personajeService.findByAge(age);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @GetMapping(params = "movie")
    public ResponseEntity<?> findByMovie(@RequestParam Long idMovie){
        List<PersonajeDTO> dtos = personajeService.findByMovie(idMovie);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

}
