package com.memesystem.my_firts_app_springboot.controller;

import com.memesystem.my_firts_app_springboot.entity.Persona;
import com.memesystem.my_firts_app_springboot.service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personas")
public class Personacontroller {
    @Autowired
    private PersonaServiceImpl personServiceImpl;

    @PostMapping
    public ResponseEntity<Persona> save (@RequestBody Persona persona) {
        try {
            Persona save = personServiceImpl.save(persona);
            return new ResponseEntity<>(save, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Persona> update(@RequestBody Persona persona) {
        try {
            Persona save = personServiceImpl.update(persona);
            return new ResponseEntity<>(save, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Persona>> getAllPersona() {
        return new ResponseEntity<>(personServiceImpl.getPersona(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
        Optional<Persona> persona = personServiceImpl.getPersonaById(id);
        return persona.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        Optional<Persona> persona = personServiceImpl.getPersonaById(id);
        if (persona.isPresent()) {
            personServiceImpl.deletePersona(persona.get().getId());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
