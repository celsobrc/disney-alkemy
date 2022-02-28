package com.alkemy.disney.repository;


import com.alkemy.disney.entity.PersonajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeEntity, Long> {

    List<PersonajeEntity> findByName(String name);

    List<PersonajeEntity> findByAge(Integer age);

    List<PersonajeEntity> findALLByFilmsId( Long idMovie);
}
