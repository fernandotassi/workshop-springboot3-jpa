package com.fernando.udem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.fernando.udem.entities.Pedido;
import com.fernando.udem.repositorios.RepositorioPedido;

@Service
public class ServicoPedido 
{
	 @Autowired	
     private RepositorioPedido repos;
	 
	 public List<Pedido> findAll()
	 {
		 return repos.findAll();
	 }
	 
	 public Pedido findById(Long id)
	 {
		 Optional<Pedido> opt = repos.findById(id);
		 return opt.get();
	 }
}
