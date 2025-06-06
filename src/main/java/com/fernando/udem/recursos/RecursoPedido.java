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
@RequestMapping(value = "/pedidoers")
public class RecursoPedido 
{
	 @Autowired
     private ServicoPedido servicoPedido;
	 
	 @GetMapping
	 public ResponseEntity<List<Pedido>> encontraTodos()
	 {
		 List<Pedido> lista = servicoPedido.encontraTodos();
		 return ResponseEntity.ok().body(lista);
	 }
	 
	 @GetMapping(value = "/{id}")
	 public ResponseEntity<Pedido> encotraPeloId(@PathVariable Long id)
	 {
		 Pedido ped = servicoPedido.encontraPeloId(id);
		 return ResponseEntity.ok().body(ped);
	 }	 
}
