package com.fernando.udem.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fernando.udem.entities.enums.StatusPedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")     
public class Pedido implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	private Instant momento;	
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	public Pedido(){}
	public Pedido(Long id, Instant momento, Usuario cliente, StatusPedido status)
	{this.id = id; this.momento = momento; this.cliente = cliente; setStatus(status);}
	
	public void setMomento(Instant momento){this.momento = momento;}
	public void setCliente(Usuario cliente){this.cliente = cliente;}
	public void setPagamento(Pagamento pagamento){this.pagamento = pagamento;}
	public void setStatus(StatusPedido status)
	{
		if(status != null)
		    this.status = status.getCode();
	}
	
	public Long getId(){return id;}
	public Instant getMomento(){return momento;}
	public Usuario getCliente(){return cliente;}
	public StatusPedido getStatus(){return StatusPedido.valor(status);}
	public Set<ItemPedido> getItens(){return itens;}
	public Pagamento getPagamento(){return pagamento;}
	
	public Double getTotal()
	{
		double soma = 0.;
		for(ItemPedido ip: itens)
             soma += ip.getSubTotal();
		return soma;
	}
			
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
	
	public String toString()
	{return "id: " + ", momento: " + momento + ", status: " + status;}
     
} 
