package com.portifolio.workshop.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portifolio.workshop.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
}