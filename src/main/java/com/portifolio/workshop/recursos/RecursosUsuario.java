package com.portifolio.workshop.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portifolio.workshop.entidades.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursosUsuario {

	@GetMapping
	public ResponseEntity<Usuario> findAll(){
		Usuario u = new Usuario(1L, "Maria", "maria@gmail.com", "9999999", "123456");
		return ResponseEntity.ok().body(u);
	}
}