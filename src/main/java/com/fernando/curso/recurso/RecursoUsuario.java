package com.fernando.curso.recurso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.curso.entities.Usuario;
import com.fernando.curso.services.UsuarioService;

@RestController
@RequestMapping(value="/susers")
public class RecursoUsuario 
{
	 @Autowired
	 private UsuarioService servico;
	
	 @GetMapping
     public ResponseEntity<List<Usuario>>findAll()
     {
    	 List<Usuario> lista = servico.findAll();
         return ResponseEntity.ok().body(lista);
     }
	 
	 @GetMapping(value = "/{id}")
	 public ResponseEntity<Usuario> findById(@PathVariable Long id)
	 {
		 Usuario usu = servico.findById(id);
		 return ResponseEntity.ok().body(usu);
	 }
}
