package com.fernando.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.curso.entities.Usuario;
import com.fernando.curso.repositories.UsuarioRepository;

@Service
public class UsuarioService 
{
	 @Autowired
     private UsuarioRepository repositorio;
	 
	 public List<Usuario> findAll() 
	 {return repositorio.findAll();}
	 
	 public Usuario findById(Long id)
	 {
		 Optional<Usuario> op = repositorio.findById(id);
         return op.get();	 
	 }
}
