package com.portifolio.workshop.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.portifolio.workshop.entidades.Produto;
import com.portifolio.workshop.repositorios.ProdutoRepositorio;
import com.portifolio.workshop.servicos.excecoes.DatabaseException;
import com.portifolio.workshop.servicos.excecoes.RecursoNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
	
	public Produto inserir(Produto obj) {
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
	
	public Produto atualizacao(Long id, Produto obj) {
		try {
			Produto entidade = repositorio.getReferenceById(id);
			atualizacaoDados(entidade, obj);
			return repositorio.save(entidade);
		} catch (EntityNotFoundException e) {
			throw new RecursoNotFoundException(id);
		}
	}
	public void atualizacaoDados(Produto entidade, Produto obj) {
		entidade.setNome(obj.getNome());
		entidade.setDescricao(obj.getDescricao());
		entidade.setPreco(obj.getPreco());
		entidade.setImgUrl(obj.getImgUrl());
	}
}