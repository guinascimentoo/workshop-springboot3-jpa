package com.portifolio.workshop.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.portifolio.workshop.entidades.Usuario;
import com.portifolio.workshop.repositorios.UsuarioRepositorio;
import com.portifolio.workshop.servicos.excecoes.DatabaseException;
import com.portifolio.workshop.servicos.excecoes.RecursoNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ServicoUsuario {

	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> findAll(){
		return repositorio.findAll();
	}
	
	public Usuario procurarPorId(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new RecursoNotFoundException(id));
	}
	
	public Usuario inserir(Usuario obj) {
		return repositorio.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repositorio.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Usuario atualizacao(Long id, Usuario obj) {
		try {
			Usuario entidade = repositorio.getReferenceById(id);
			atualizacaoDados(entidade, obj);
			return repositorio.save(entidade);
		} catch (EntityNotFoundException e) {
			throw new RecursoNotFoundException(id);
		}
	}

	private void atualizacaoDados(Usuario entidade, Usuario obj) {	
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setNumeroCelular(obj.getNumeroCelular());
	}
}