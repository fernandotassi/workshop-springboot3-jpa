package com.fernando.udem.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.udem.entities.Usuario;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/useres")
public class RecursoUsuario 
{
	 @GetMapping	 
     public ResponseEntity<Usuario> encontraTodos()
     {
    	 Usuario u = new Usuario(1L, "maria", "maria@gmail.com", "999001234", "alice");
    	 return ResponseEntity.ok().body(u);
     }
}
