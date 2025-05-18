package com.fernando.udem.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fernando.udem.entities.Usuario;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long>
{}
