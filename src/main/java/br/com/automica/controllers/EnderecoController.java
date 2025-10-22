package br.com.automica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.automica.dtos.CadastrarEnderecoRequestDto;
import br.com.automica.dtos.CadastrarEnderecoResponseDto;
import br.com.automica.services.EnderecoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@PostMapping("cadastrar")
	public ResponseEntity<CadastrarEnderecoResponseDto> post(@RequestBody @Valid CadastrarEnderecoRequestDto request) {
		var response = enderecoService.cadastrarEndereco(request);
		return ResponseEntity.ok(response);
	}
}
