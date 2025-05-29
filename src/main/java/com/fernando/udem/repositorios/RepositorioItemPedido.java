package com.fernando.udem.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fernando.udem.entities.ItemPedido;
import com.fernando.udem.entities.pk.CPItemPedido;

@Repository
public interface RepositorioItemPedido extends JpaRepository<ItemPedido, CPItemPedido>
{}
