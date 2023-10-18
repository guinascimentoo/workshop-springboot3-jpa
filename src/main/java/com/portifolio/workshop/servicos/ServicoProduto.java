package com.portifolio.workshop.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portifolio.workshop.entidades.Produto;
import com.portifolio.workshop.repositorios.ProdutoRepositorio;

@Service
public class ServicoProduto {

	@Autowired
	private ProdutoRepositorio repositorio;
	
	public List<Produto> findAll(){
		return repositorio.findAll();
	}
	
	public Produto procurarPorId(Long id) {
		Optional<Produto> obj = repositorio.findById(id);
		return obj.get();
	}
}