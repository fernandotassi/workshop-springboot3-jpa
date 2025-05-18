package com.fernando.udem.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fernando.udem.entities.Usuario;
import com.fernando.udem.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner
{ 
	  @Autowired
      private RepositorioUsuario repo;

	  @Override
	  public void run(String... args) throws Exception 
	  {
		    Usuario u1 = new Usuario(null, "maria white", "maria@gmail.com", "981230034", "1243");
		    Usuario u2 = new Usuario(null, "ana purple", "ana@gmail.com", "983451200", "3421");
		    
		    repo.saveAll(Arrays.asList(u1, u2));
	  }
	   
}
