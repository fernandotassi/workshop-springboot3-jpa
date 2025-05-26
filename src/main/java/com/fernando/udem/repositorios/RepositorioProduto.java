package com.fernando.udem.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fernando.udem.entities.Produto;

@Repository
public interface RepositorioProduto extends JpaRepository<Produto, Long>
{}
