package com.portifolio.workshop.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portifolio.workshop.entidades.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long>{
}