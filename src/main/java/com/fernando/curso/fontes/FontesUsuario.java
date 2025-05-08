package com.fernando.curso.fontes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.curso.entities.Usuario;

@RestController
@RequestMapping(value="/users")
public class FontesUsuario 
{
	 @GetMapping
     public ResponseEntity<Usuario> findAll()
     {
    	 Usuario u = new Usuario(1L, "maria", "maria@gmail.com",
    		                     "999990099", "@maria9");
         return ResponseEntity.ok().body(u);
     }
}
