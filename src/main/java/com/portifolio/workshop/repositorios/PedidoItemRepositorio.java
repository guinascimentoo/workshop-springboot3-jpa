package com.portifolio.workshop.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portifolio.workshop.entidades.PedidoItem;

public interface PedidoItemRepositorio extends JpaRepository<PedidoItem, Long>{
}