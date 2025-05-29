package com.fernando.udem.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable
{
     private static final long serialVersionUID = 1L;
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
     private String nome;
     private String email;
     private String fone;
     private String password;
     
     @JsonIgnore
     @OneToMany(mappedBy = "cliente")
     private List<Pedido> pedidos = new ArrayList<>();
     
     public Usuario(){}
     public Usuario(Long id, String nome, String email, String fone,String password)
     {this.id = id; this.nome = nome; this.email = email; this.fone = fone; this.password 
      = password;}
     
     public Long getId(){return id;}
     public String getNome(){return nome;}
     public String getEmail(){return email;}
     public String getFone(){return fone;}
     public String getPassword(){return password;}
	 public List<Pedido> getPedidos(){return pedidos;}
     
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	 }
	 
	 public String toString()
	 {
		 return "id: " + id + ", nome: " + nome + ", email: " + email + ", fone: " + fone
				 + ", password: " + password;
	 }    
}
