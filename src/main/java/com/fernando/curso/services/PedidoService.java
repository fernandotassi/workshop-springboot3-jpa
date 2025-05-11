package com.fernando.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.curso.entities.Pedido;
import com.fernando.curso.repositories.PedidoRepository;

@Service
public class PedidoService
{
	 @Autowired
     private PedidoRepository repositorio;
	 
	 public List<Pedido> findAll()
	 {
		 return repositorio.findAll();
	 }
	 
	 public Pedido findById(Long id)
	 {
		  Optional<Pedido> op = repositorio.findById(id);
		  return op.get();
	 }   
}
