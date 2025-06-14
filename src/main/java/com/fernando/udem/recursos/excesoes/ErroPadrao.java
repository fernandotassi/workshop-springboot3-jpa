package com.fernando.udem.recursos.excesoes;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErroPadrao implements Serializable
{	 
     private static final long serialVersionUID = 1L;
	 
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
     private Instant momento;
     private Integer codigo; 
     private String erro;
     private String mensagem;
     private String caminho;
     
     public ErroPadrao(){}
     public ErroPadrao(Instant momento, Integer codigo, String erro, String mensagem
    		           , String caminho)
     {this.momento = momento; this.codigo = codigo; this.erro = erro; this.mensagem
      = mensagem; this.caminho = caminho;}
     
     public void setMomento(Instant momento){this.momento = momento;}
     public void setCodigo(Integer codigo){this.codigo = codigo;}
     public void setErro(String erro){this.erro = erro;}
     public void setMensagem(String mensagem){this.mensagem = mensagem;}
     public void setCaminho(String caminho){this.caminho = caminho;}
     
     public Instant getMomento(){return momento;}
     public Integer getCodigo(){return codigo;}
     public String getErro(){return erro;}
     public String getMensagem(){return mensagem;}
     public String getCaminho(){return caminho;}
     
     
}
