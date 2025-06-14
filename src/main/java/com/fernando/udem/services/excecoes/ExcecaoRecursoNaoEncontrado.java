package com.fernando.udem.services.excecoes;

public class ExcecaoRecursoNaoEncontrado extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	public ExcecaoRecursoNaoEncontrado(Object id)
	{super("recurso não encontrado. Id " + id);}
}
