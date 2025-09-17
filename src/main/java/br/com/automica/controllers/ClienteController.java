package br.com.automica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.automica.dtos.CadastrarClienteRequestDto;
import br.com.automica.dtos.ConsultarCpfRequestDto;
import br.com.automica.services.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping("cadastrar")
	public ResponseEntity<?> post(@RequestBody @Valid CadastrarClienteRequestDto request) {
		var response = clienteService.cadastrarCliente(request);
		return ResponseEntity.ok(response);
	}

	@PostMapping("consultar")
	public ResponseEntity<?> get(@Valid @RequestBody ConsultarCpfRequestDto request) {
		var response = clienteService.consultarCpf(request);
		return ResponseEntity.ok().body(response);
	}
}
