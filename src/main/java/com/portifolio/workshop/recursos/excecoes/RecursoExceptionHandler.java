package com.portifolio.workshop.recursos.excecoes;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.portifolio.workshop.servicos.excecoes.DatabaseException;
import com.portifolio.workshop.servicos.excecoes.RecursoNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RecursoExceptionHandler {

	@ExceptionHandler(RecursoNotFoundException.class)
	public ResponseEntity<ErroPadrao> recursoNaoEncontrado(RecursoNotFoundException e, HttpServletRequest solicitar){
		String erro = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), solicitar.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<ErroPadrao> database(DatabaseException e, HttpServletRequest solicitar){
		String erro = "Erro base de dados ";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), solicitar.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}