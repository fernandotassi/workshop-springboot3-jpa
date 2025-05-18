package com.fernando.udem.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fernando.udem.entities.Usuario;
import com.fernando.udem.repositorios.RepositorioUsuario;

@Service
public class ServicoUsuario 
{
	 @Autowired
     private RepositorioUsuario repo;
	 
	 public List<Usuario> encontraTodos()
	 {
		  return repo.findAll();
	 }	
	 
	 public Usuario encontraPeloId(Long id)
	 {
		   Optional<Usuario> op = repo.findById(id);
		   return op.get();
	 }
}
