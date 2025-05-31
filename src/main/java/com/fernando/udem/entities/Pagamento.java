package com.fernando.udem.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagamento")
public class Pagamento implements Serializable
{
	  private static final long serialVersionUID = 1L; 
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
      private Instant momento;
      
	  @JsonIgnore
	  @OneToOne
	  @MapsId
      private Pedido pedido;
      
      public Pagamento(){}
      public Pagamento(Long id, Instant momento, Pedido pedido)
      {this.id = id; this.momento = momento; this.pedido = pedido;}
      
      public void setId(Long id){this.id = id;}
      public void setMomento(Instant momento){this.momento = momento;}
      public void setPedido(Pedido pedido){this.pedido = pedido;}
      
      public Long getId(){return id;}
      public Instant getMomento(){return momento;}
      public Pedido getPedido(){return pedido;}
      
	  @Override
	  public int hashCode() {
		return Objects.hash(id);
	  }
	  @Override
	  public boolean equals(Object obj) {
	 	if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		return Objects.equals(id, other.id);
	  }
      
      public String toString()
      {return "id: " + id + ", momento: " + momento;}
}
