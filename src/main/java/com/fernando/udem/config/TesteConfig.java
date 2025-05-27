package com.fernando.udem.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fernando.udem.entities.Categoria;
import com.fernando.udem.entities.Pedido;
import com.fernando.udem.entities.Produto;
import com.fernando.udem.entities.Usuario;
import com.fernando.udem.entities.enums.StatusPedido;
import com.fernando.udem.repositorios.RepositorioCategoria;
import com.fernando.udem.repositorios.RepositorioPedido;
import com.fernando.udem.repositorios.RepositorioProduto;
import com.fernando.udem.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner
{ 
	  @Autowired
      private RepositorioUsuario repositorioUsuario;
	  @Autowired
	  private RepositorioPedido repositorioPedido;
	  @Autowired
	  private RepositorioCategoria repositorioCategoria;
	  @Autowired
	  private RepositorioProduto repositorioProduto;

	  @Override
	  public void run(String... args) throws Exception 
	  {
		    Usuario u1 = new Usuario(null, "maria white", "maria@gmail.com", "981230034", "1243");
		    Usuario u2 = new Usuario(null, "ana purple", "ana@gmail.com", "983451200", "3421");
		    
		    Pedido p1 = new Pedido(null, Instant.parse("2025-06-20T19:53:07Z"), u1, StatusPedido.esperando);
		    Pedido p2 = new Pedido(null, Instant.parse("2025-07-21T03:42:10Z"), u2, StatusPedido.enviado);
		    Pedido p3 = new Pedido(null, Instant.parse("2025-07-22T15:21:22Z"), u1, StatusPedido.pago);
		    
		    Categoria cat1 = new Categoria(null, "eletro");
		    Categoria cat2 = new Categoria(null, "brinquedo");
		    Categoria cat3 = new Categoria(null, "informática");
		    
		    Produto prod = new Produto(null, "senhor dos aneis", "melhor dos jogos",150., "jogos.com");
		    Produto prod1 = new Produto(null, "smart tv", "melhor das tvs", 2090., "tvs.com");
		    Produto prod2 = new Produto(null, "mackbook", "melhor dos notebooks", 4500., "notebooks.com");
		    Produto prod3 = new Produto(null, "pc", "melhor dos pcs", 3450., "pcs.com");
		    Produto prod4 = new Produto(null, "rails for dummies", "melhor dos jogos", 100., "jogos.com");
		    
		    repositorioUsuario.saveAll(Arrays.asList(u1, u2));
		    repositorioPedido.saveAll(Arrays.asList(p1, p2, p3));
		    repositorioCategoria  .saveAll(Arrays.asList(cat1, cat2, cat3));
		    repositorioProduto.saveAll(Arrays.asList(prod, prod1, prod2, prod3, prod4));
		    
		    prod.getCategorias().add(cat2);
		    prod1.getCategorias().add(cat1);
		    prod2.getCategorias().add(cat3);
		    prod2.getCategorias().add(cat1);
		    prod3.getCategorias().add(cat3);
		    prod3.getCategorias().add(cat1);
		    prod4.getCategorias().add(cat2);
		    
		    repositorioProduto.saveAll(Arrays.asList(prod, prod1, prod2, prod3, prod4));
	  }	 
}
