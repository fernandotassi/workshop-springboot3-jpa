package com.fernando.udem.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fernando.udem.entities.Categoria;

@Repository
public interface RepositorioCategoria extends JpaRepository<Categoria, Long>
{}
