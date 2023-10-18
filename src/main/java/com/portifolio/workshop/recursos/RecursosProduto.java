package com.portifolio.workshop.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portifolio.workshop.entidades.Produto;
import com.portifolio.workshop.servicos.ServicoProduto;

@RestController
@RequestMapping(value = "/produtos")
public class RecursosProduto {

	@Autowired
	private ServicoProduto servico;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> lista = servico.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> procurarPorId(@PathVariable Long id){
		Produto obj = servico.procurarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}