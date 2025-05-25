package com.fernando.udem.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fernando.udem.entities.Categoria;
import com.fernando.udem.entities.Pedido;
import com.fernando.udem.entities.Usuario;
import com.fernando.udem.entities.enums.StatusPedido;
import com.fernando.udem.repositorios.RepositorioCategoria;
import com.fernando.udem.repositorios.RepositorioPedido;
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
		    
		    repositorioUsuario.saveAll(Arrays.asList(u1, u2));
		    repositorioPedido.saveAll(Arrays.asList(p1, p2, p3));
		    repositorioCategoria  .saveAll(Arrays.asList(cat1, cat2, cat3));
	  }	 
}
