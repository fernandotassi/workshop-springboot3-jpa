package com.fernando.udem.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.fernando.udem.entities.Pedido;
import com.fernando.udem.entities.Produto;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class CPItemPedido implements Serializable
{
	 private static final Long serialVersionUID = 1L;
	 
	 @ManyToOne
	 @JoinColumn(name = "pedido_id")
     private Pedido pedido;
	 @ManyToOne
	 @JoinColumn(name = "produto_id")
     private Produto produto;
    
     public void setPedido(Pedido pedido){this.pedido = pedido;}
     public void setProduto(Produto produto){this.produto = produto;}
     public Pedido getPedido(){return pedido;}
     public Produto getProduto(){return produto;}
     
	 @Override
	 public int hashCode() 
	 {
		return Objects.hash(pedido, produto);
	 }
	 @Override
	 public boolean equals(Object obj)
	 {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CPItemPedido other = (CPItemPedido) obj;
		return Objects.equals(pedido, other.pedido) && Objects.equals(produto, other.produto);
	 }
     
     
}
