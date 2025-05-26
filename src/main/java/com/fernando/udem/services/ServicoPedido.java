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
     private RepositorioPedido repositorioPedido;
	 
	 public List<Pedido> encontraTodos()
	 {
		 return repositorioPedido.findAll();
	 }
	 
	 public Pedido encontraPeloId(Long id)
	 {
		 Optional<Pedido> opt = repositorioPedido.findById(id);
		 return opt.get();
	 }
}
