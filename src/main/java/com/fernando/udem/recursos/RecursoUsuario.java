package com.fernando.udem.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.udem.entities.Usuario;
import com.fernando.udem.services.ServicoUsuario;

@RestController
@RequestMapping(value = "/useres")
public class RecursoUsuario 
{
	 @Autowired
	 private ServicoUsuario serv;
	
	 @GetMapping	 
     public ResponseEntity<List<Usuario>> encontraTodos()
     {
    	 List<Usuario> lista = serv.encontraTodos();
    	 return ResponseEntity.ok().body(lista);
     }
	 
	 @GetMapping(value = "/{id}")
	 public ResponseEntity<Usuario> encontraPeloId(@PathVariable Long id)
	 {
		 Usuario us = serv.encontraPeloId(id);
		 return ResponseEntity.ok().body(us);
	 }
	 
	 
	 
	 
}
