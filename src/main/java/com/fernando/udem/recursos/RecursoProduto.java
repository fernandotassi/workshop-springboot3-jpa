package com.fernando.udem.recursos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.udem.entities.Produto;
import com.fernando.udem.services.ServicoProduto;

@RestController
@RequestMapping(value = "/produtoses")
public class RecursoProduto
{
	 @Autowired
     private ServicoProduto servicoProduto;
	 
	 @GetMapping
	 public ResponseEntity<List<Produto>> encontraTodos()
	 {
		 List<Produto> lista = servicoProduto.encontraTodos();
		 return ResponseEntity.ok().body(lista);
	 }
	 
	 @GetMapping(value = "/{id}")
	 public ResponseEntity<Produto> encontraPeloId(@PathVariable Long id)
	 {
		 Produto prod = servicoProduto.encotraPeloId(id);
		 return ResponseEntity.ok().body(prod);
	 }
}
	 
  