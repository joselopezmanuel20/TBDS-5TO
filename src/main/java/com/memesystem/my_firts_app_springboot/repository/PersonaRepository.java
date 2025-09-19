package com.memesystem.my_firts_app_springboot.repository;

import com.memesystem.my_firts_app_springboot.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long > {
}
