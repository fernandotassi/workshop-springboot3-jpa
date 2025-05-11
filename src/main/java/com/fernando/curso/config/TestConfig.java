package com.fernando.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fernando.curso.entities.Pedido;
import com.fernando.curso.entities.Usuario;
import com.fernando.curso.repositories.PedidoRepository;
import com.fernando.curso.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner
{
    @Autowired 
	private UsuarioRepository usuarioRepository;
    
    @Autowired
    private PedidoRepository pedidoRepository;

	@Override
	public void run(String... args) throws Exception
	{
		 Usuario u1 = new Usuario(null, "Mark Brown", "brown@gmail.com", 
				                  "981234565", "54321");
		 Usuario u2 = new Usuario(null, "Deep Purple", "deep@outlook.com",
				                  "991348900", "27369");
		 usuarioRepository.saveAll(Arrays.asList(u1, u2));
		 
		 Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		 Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T15:21:22Z"), u2);
		 Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T03:42:10Z"), u1);
		 
		 pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
	} 
	
}
