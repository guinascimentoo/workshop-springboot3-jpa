package com.portifolio.workshop.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portifolio.workshop.entidades.Pedido;
import com.portifolio.workshop.repositorios.PedidoRepositorio;

@Service
public class ServicoPedido {

	@Autowired
	private PedidoRepositorio repositorio;
	
	public List<Pedido> findAll(){
		return repositorio.findAll();
	}
	
	public Pedido procurarPorId(Long id) {
		Optional<Pedido> obj = repositorio.findById(id);
		return obj.get();
	}
}