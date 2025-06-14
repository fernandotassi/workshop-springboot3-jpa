package com.fernando.udem.recursos.excecoes;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fernando.udem.services.excecoes.ExcecaoBancoDados;
import com.fernando.udem.services.excecoes.ExcecaoRecursoNaoEncontrado;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExcecaoManualRecurso
{
	 @ExceptionHandler(ExcecaoRecursoNaoEncontrado.class)	 
     public ResponseEntity<ErroPadrao> recursoNaoEncontrado(ExcecaoRecursoNaoEncontrado e,
    		                                                 HttpServletRequest requisito)
     {
		 String erro = "recurso não encontrado";
		 HttpStatus status = HttpStatus.NOT_FOUND;
    	 ErroPadrao erra = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(),
    			                          requisito.getRequestURI());
		 return ResponseEntity.status(status).body(erra);
     } 
	 
	 @ExceptionHandler(ExcecaoBancoDados.class)
	 public ResponseEntity<ErroPadrao> excecaoBancoDados(ExcecaoBancoDados e,
	 		                                              HttpServletRequest requisito)	 
	 {
		 String erro = "violação banco de dados";
		 HttpStatus status = HttpStatus.BAD_REQUEST;
		 ErroPadrao erra = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(),
				                          requisito.getRequestURI());
		 return ResponseEntity.status(status).body(erra);
	 }
}
