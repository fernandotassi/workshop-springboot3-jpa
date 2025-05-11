package com.fernando.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.curso.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>
{
       
}
