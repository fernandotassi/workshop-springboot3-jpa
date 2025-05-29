package com.fernando.udem.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fernando.udem.entities.pk.CPItemPedido;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_pedido")
public class ItemPedido implements Serializable
{
     private static final long serialVersionUID = 1L;
     
     @EmbeddedId
	 private CPItemPedido id = new CPItemPedido();
     
     private Integer quantidade;
     private double preco;
     
     public ItemPedido(){}
     public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco)
     {id.setPedido(pedido); id.setProduto(produto); this.quantidade = quantidade; this.preco = preco;}
     
     public void setQuantidade(Integer quantidade){this.quantidade = quantidade;}
     public void setPreco(Double preco){this.preco = preco;}
     public void setPedido(Pedido pedido){id.setPedido(pedido);}
     public void setProduto(Produto produto){id.setProduto(produto);}
     
     public Integer getQuantidade(){return quantidade;}
     public Double getPreco(){return preco;}     
     public Produto getProduto(){return id.getProduto();}
     @JsonIgnore
     public Pedido getPedido(){return id.getPedido();}
     
	 @Override
	 public int hashCode() 
	 {
		return Objects.hash(id);
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
			ItemPedido other = (ItemPedido) obj;
			return Objects.equals(id, other.id);
	 }
     
     
}
