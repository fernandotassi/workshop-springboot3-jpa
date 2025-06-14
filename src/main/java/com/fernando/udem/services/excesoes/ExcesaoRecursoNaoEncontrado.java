package com.fernando.udem.services.excesoes;

public class ExcesaoRecursoNaoEncontrado extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	public ExcesaoRecursoNaoEncontrado(Object id)
	{super("recurso não encontrado. Id " + id);}
}
