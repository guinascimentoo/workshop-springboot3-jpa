package com.portifolio.workshop.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portifolio.workshop.entidades.Usuario;
import com.portifolio.workshop.repositorios.UsuarioRepositorio;

@Service
public class ServicoUsuario {

	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> findAll(){
		return repositorio.findAll();
	}
	
	public Usuario procurarPorId(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.get();
	}
	
	public Usuario inserir(Usuario obj) {
		return repositorio.save(obj);
	}
	
	public void delete(Long id) {
		repositorio.deleteById(id);
	}
}