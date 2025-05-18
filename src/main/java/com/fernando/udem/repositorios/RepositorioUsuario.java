package com.fernando.udem.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fernando.udem.entities.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long>
{}
