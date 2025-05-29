 package com.fernando.udem.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fernando.udem.entities.Pedido;

@Repository
public interface RepositorioPedido extends JpaRepository<Pedido, Long>
{}
