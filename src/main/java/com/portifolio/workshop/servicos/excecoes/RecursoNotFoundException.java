package com.portifolio.workshop.servicos.excecoes;

public class RecursoNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public RecursoNotFoundException(Object id) {
		super("Recurso não encontrado. Id:" + id);
	}
}