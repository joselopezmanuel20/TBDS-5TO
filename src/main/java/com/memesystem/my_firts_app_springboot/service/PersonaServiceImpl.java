package com.memesystem.my_firts_app_springboot.service;

import com.memesystem.my_firts_app_springboot.entity.Persona;
import com.memesystem.my_firts_app_springboot.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona update(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public List<Persona> getPersona() {
        return personaRepository.findAll();
    }

    @Override
    public Optional<Persona> getPersonaById(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }
}
