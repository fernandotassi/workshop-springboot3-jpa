package com.fernando.udem.entities;

import java.io.Serializable;
import java.util.Objects;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	public Categoria(){}
	public Categoria(Long id, String nome)
	{this.id = id; this.nome = nome;}
	
	public void setId(Long id){this.id = id;}
	public void setNome(String nome){this.nome = nome;}
	public Long getId(){return id;}
	public String getNome(){return nome;}
	
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
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString(){return "id: " + id + ", nome: " + nome;}
}
