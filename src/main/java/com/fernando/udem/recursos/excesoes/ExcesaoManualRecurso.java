package com.fernando.udem.recursos.excesoes;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fernando.udem.services.excesoes.ExcesaoRecursoNaoEncontrado;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExcesaoManualRecurso
{
	 @ExceptionHandler(ExcesaoRecursoNaoEncontrado.class)	 
     public ResponseEntity<ErroPadrao> recursoNaoEncontrado(ExcesaoRecursoNaoEncontrado e,
    		                                                 HttpServletRequest requisito)
     {
		 String erro = "recurso não encontrado";
		 HttpStatus status = HttpStatus.NOT_FOUND;
    	 ErroPadrao erra = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(),
    			                          requisito.getRequestURI());
		 return ResponseEntity.status(status).body(erra);
     }    
}
