package com.portifolio.workshop.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portifolio.workshop.entidades.Categoria;
import com.portifolio.workshop.servicos.ServicoCategoria;

@RestController
@RequestMapping(value = "/categorias")
public class RecursosCategoria {

	@Autowired
	private ServicoCategoria servico;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(){
		List<Categoria> lista = servico.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> procurarPorId(@PathVariable Long id){
		Categoria obj = servico.procurarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}