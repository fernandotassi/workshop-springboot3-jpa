package com.fernando.udem.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.fernando.udem.entities.Usuario;
import com.fernando.udem.repositorios.RepositorioUsuario;
import com.fernando.udem.services.excecoes.ExcecaoBancoDados;
import com.fernando.udem.services.excecoes.ExcecaoRecursoNaoEncontrado;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ServicoUsuario 
{
	 @Autowired
     private RepositorioUsuario repositorioUsuario;
	 
	 public List<Usuario> encontraTodos()
	 {
		  return repositorioUsuario.findAll();
	 }	
	 
	 public Usuario encontraPeloId(Long id)
	 {
		   Optional<Usuario> op = repositorioUsuario.findById(id);
		   return op.orElseThrow(() -> new ExcecaoRecursoNaoEncontrado(id));
	 }
	 
	 public Usuario adiciona(Usuario us)
	 {
		 return repositorioUsuario.save(us);		 
	 }
	 
	 public void delete(Long id)
	 {
		 try
		 {
		     repositorioUsuario.deleteById(id);
		 }		 
		 catch(EmptyResultDataAccessException e)
		 {throw new ExcecaoRecursoNaoEncontrado(id);}
		 catch(DataIntegrityViolationException e)
		 {throw new ExcecaoBancoDados(e.getMessage());}
	 }
	 
	 public Usuario atualiza(Long id, Usuario user)
	 {
		  
		 try
		 {
			 Usuario usu = repositorioUsuario.getReferenceById(id);
			 atualizaDados(usu, user);
			 return repositorioUsuario.save(usu);
		 }
		 catch(EntityNotFoundException e)
		 {throw new ExcecaoRecursoNaoEncontrado(id);}
		 
	 }
	 
	 public void atualizaDados(Usuario u1, Usuario u2)
	 {			 	
			  u1.setNome(u2.getNome()); 
			  u1.setEmail(u2.getEmail());
			  u1.setFone(u2.getFone());			 
	 }
}
