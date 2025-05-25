package com.fernando.udem.entities.enums;


public enum StatusPedido
{
     esperando(0), pago(1), enviado(2), entregue(3), devolvido(4);
	
	private int code;
	
	private StatusPedido(int code){this.code = code;}
	
	public void setCode(int code){this.code = code;}
	public int getCode(){return code;}
	
	public static StatusPedido valor(int code)
	{
		for(StatusPedido valor : StatusPedido.values())
		{
			if(valor.getCode() == code)
				return valor;			
		}	
		throw new IllegalArgumentException("código inválido");
	}
}
