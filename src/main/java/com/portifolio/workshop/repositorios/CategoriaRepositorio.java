package com.portifolio.workshop.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portifolio.workshop.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{
}