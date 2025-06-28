package com.fernando.udem.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fernando.udem.entities.Usuario;
import com.fernando.udem.services.ServicoUsuario;

@RestController
@RequestMapping(value = "/usuariosers")
public class RecursoUsuario 
{
	 @Autowired
	 private ServicoUsuario servicoUsuario;
	
	 @GetMapping	 
     public ResponseEntity<List<Usuario>> encontraTodos()
     {
    	 List<Usuario> lista = servicoUsuario.encontraTodos();
    	 return ResponseEntity.ok().body(lista);
     }
	 
	 @GetMapping(value = "/{id}")
	 public ResponseEntity<Usuario> encontraPeloId(@PathVariable Long id)
	 {
		 Usuario usuario = servicoUsuario.encontraPeloId(id);
		 return ResponseEntity.ok().body(usuario);
	 } 
	     
	 @PostMapping
	 public ResponseEntity<Usuario> adiciona(@RequestBody Usuario obj)
	 {
		  Usuario us = servicoUsuario.adiciona(obj);
		  URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				    .buildAndExpand(us.getId()).toUri();
		  return ResponseEntity.created(uri).body(us);
	 }
	 
	 @DeleteMapping(value = "/{id}")
	 public ResponseEntity<Void> delete(@PathVariable Long id)
	 {
		  servicoUsuario.delete(id); 
		  return ResponseEntity.noContent().build();
	 }
	 
	 @PutMapping(value = "/{id}")
	 public ResponseEntity<Usuario> atualiza(@PathVariable Long id, @RequestBody Usuario user)
	 {
		 user = servicoUsuario.atualiza(id, user);
		 return ResponseEntity.ok().body(user);
	 }
}
