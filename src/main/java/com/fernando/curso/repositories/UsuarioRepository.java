package com.fernando.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.curso.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{

}
