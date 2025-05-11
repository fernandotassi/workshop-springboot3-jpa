package com.fernando.curso.recurso;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.curso.entities.Pedido;
import com.fernando.curso.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class RecursoPedido 
{
     private PedidoService service;
     
     @GetMapping
     public ResponseEntity<List<Pedido>> findAll() 
     {
    	  List<Pedido> lista = service.findAll();
    	  return ResponseEntity.ok().body(lista);
     }
     
     public ResponseEntity<Pedido> findById(@PathVariable Long id)
     {
    	 Pedido pedido = service.findById(id);
    	 return ResponseEntity.ok().body(pedido);
     }
}
