package com.fernando.udem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.udem.entities.Produto;
import com.fernando.udem.repositorios.RepositorioProduto;

@Service
public class ServicoProduto 
{
	@Autowired
    private RepositorioProduto repositorioProduto;
    
    public List<Produto> encontraTodos()
    {return repositorioProduto.findAll();}
    
    public Produto encotraPeloId(Long id)
    {
    	Optional<Produto> opt = repositorioProduto.findById(id);
    	return opt.get();
    }
}
