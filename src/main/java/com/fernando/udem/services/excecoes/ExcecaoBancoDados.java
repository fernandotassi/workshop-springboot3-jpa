package com.fernando.udem.services.excecoes;

public class ExcecaoBancoDados extends RuntimeException
{
     private static final long serialVersionUID = 1L;
     
     public ExcecaoBancoDados(String msg){super(msg);}
}
