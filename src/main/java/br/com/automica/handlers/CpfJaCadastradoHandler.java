package br.com.automica.handlers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.automica.exceptions.CpfJaCadastradoException;

@ControllerAdvice
public class CpfJaCadastradoHandler {
	@ExceptionHandler(CpfJaCadastradoException.class)
	public ResponseEntity<Object> handlerCpfJaCadastrado(CpfJaCadastradoException ex) {
		Map<String, Object> body = new HashMap<>();

		body.put("timestamp", LocalDateTime.now());
		body.put("status", HttpStatus.CONFLICT.value());
		body.put("errors", ex.getMessage());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
	}

}
