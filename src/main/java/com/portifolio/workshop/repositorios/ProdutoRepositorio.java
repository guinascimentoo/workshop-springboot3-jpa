package com.portifolio.workshop.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portifolio.workshop.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long>{
}