package com.fernando.udem.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fernando.udem.entities.Categoria;
import com.fernando.udem.services.ServicoCategoria;

@RestController
@RequestMapping(value = "/categoriasers")
public class RecursoCategoria 
{
     @Autowired
     private ServicoCategoria servicoCategoria;
     
     @GetMapping
     public ResponseEntity<List<Categoria>> encontraTodos()
     {
    	 List<Categoria> lista = servicoCategoria.encontraTodos();
    	 return ResponseEntity.ok().body(lista);
     }
     
     @GetMapping(value = "/{id}")
     public ResponseEntity<Categoria> encontraPeloId(@PathVariable Long id)
     {
    	 Categoria cat = servicoCategoria.encontraPeloId(id);
    	 return ResponseEntity.ok().body(cat);
     }
     
}
