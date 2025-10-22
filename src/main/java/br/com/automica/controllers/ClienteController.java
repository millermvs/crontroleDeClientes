package br.com.automica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.automica.dtos.CadastrarClienteRequestDto;
import br.com.automica.dtos.CadastrarClienteResponseDto;
import br.com.automica.dtos.ConsultarCpfResponseDto;
import br.com.automica.services.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping("cadastrar")
	public ResponseEntity<CadastrarClienteResponseDto> post(@RequestBody @Valid CadastrarClienteRequestDto request) {
		var response = clienteService.cadastrarCliente(request);
		return ResponseEntity.ok(response);
	}

	@GetMapping("consultar/{cpf}")
	public ResponseEntity<ConsultarCpfResponseDto> get(@PathVariable String cpf) {
		var response = clienteService.consultarCpf(cpf);
		return ResponseEntity.ok().body(response);
	}

}
