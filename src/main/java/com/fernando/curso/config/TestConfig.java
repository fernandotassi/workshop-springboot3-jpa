package com.fernando.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fernando.curso.entities.Usuario;
import com.fernando.curso.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner
{
    @Autowired 
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception
	{
		 Usuario u1 = new Usuario(null, "Mark Brown", "brown@gmail.com", 
				                  "981234565", "54321");
		 Usuario u2 = new Usuario(null, "Deep Purple", "deep@outlook.com",
				                  "991348900", "27369");
		 usuarioRepository.saveAll(Arrays.asList(u1, u2));
	}
    
    
    
}
