package com.fernando.udem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.udem.entities.Categoria;
import com.fernando.udem.repositorios.RepositorioCategoria;

@Service
public class ServicoCategoria 
{
	 @Autowired
     private RepositorioCategoria repositorioCategoria;
	 
	 public List<Categoria> encontraTodos()
	 {return repositorioCategoria.findAll();}
	 
	 public Categoria encontraPeloId(Long id)
	 {
		 Optional<Categoria> opt = repositorioCategoria.findById(id);
		 return opt.get();
	 }
}
