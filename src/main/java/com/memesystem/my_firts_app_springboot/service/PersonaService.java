package com.memesystem.my_firts_app_springboot.service;

import com.memesystem.my_firts_app_springboot.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    Persona save(Persona persona);

    Persona update(Persona persona);
    
    List<Persona> getPersona();

    Optional <Persona> getPersonaById(Long id);
    
    void deletePersona(Long id);

}
