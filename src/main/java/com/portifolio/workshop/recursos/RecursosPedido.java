package com.portifolio.workshop.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portifolio.workshop.entidades.Pedido;
import com.portifolio.workshop.servicos.ServicoPedido;

@RestController
@RequestMapping(value = "/pedidos")
public class RecursosPedido {

	@Autowired
	private ServicoPedido servico;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll(){
		List<Pedido> lista = servico.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> procurarPorId(@PathVariable Long id){
		Pedido obj = servico.procurarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}