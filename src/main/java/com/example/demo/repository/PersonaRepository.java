package com.example.demo.repository;

import com.example.demo.model.PersonaRec;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends JpaRepository<PersonaRec, Integer>{
    @Query(value="select o from PersonaRec o where o.dni=?1") List<PersonaRec> buscarPersonasByDni(String dni);
    @Transactional
    @Modifying
    @Query(value="delete from PersonaRec o where o.dni=?1") void eliminarPersonasByDni(String dni);
}
