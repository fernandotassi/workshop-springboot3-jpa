package com.fernando.udem.recursos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fernando.udem.entities.Pedido;
import com.fernando.udem.services.ServicoPedido;

@RestController
@RequestMapping(value = "/orderes")
public class RecursoPedido 
{
	 @Autowired
     private ServicoPedido serve;
	 
	 @GetMapping
	 public ResponseEntity<List<Pedido>> encontraTodos()
	 {
		 List<Pedido> lista = serve.findAll();
		 return ResponseEntity.ok().body(lista);
	 }
	 
	 @GetMapping(value = "/{id}")
	 public ResponseEntity<Pedido> findById(@PathVariable Long id)
	 {
		 Pedido ped = serve.findById(id);
		 return ResponseEntity.ok().body(ped);
	 }	 
}
