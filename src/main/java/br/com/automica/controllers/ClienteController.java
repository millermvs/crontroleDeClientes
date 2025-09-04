package br.com.automica.controllers;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.automica.dto.CadastrarClienteRequestDto;
import br.com.automica.entities.Cliente;
import br.com.automica.entities.Endereco;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

	@PostMapping
	public ResponseEntity<?> post(@RequestBody @Valid CadastrarClienteRequestDto requestCliente) {
		try {
			var cliente = new Cliente();

			cliente.setEndereco(new Endereco());

			cliente.getEndereco().setId(UUID.randomUUID());
			cliente.getEndereco().setCep(requestCliente.getEndereco().getCep());
			cliente.getEndereco().setRua(requestCliente.getEndereco().getRua());
			cliente.getEndereco().setNumero(requestCliente.getEndereco().getNumero());
			cliente.getEndereco().setBairro(requestCliente.getEndereco().getBairro());
			cliente.getEndereco().setCidade(requestCliente.getEndereco().getCidade());
			cliente.getEndereco().setEstado(requestCliente.getEndereco().getEstado());
			cliente.getEndereco().setPais(requestCliente.getEndereco().getPais());
			cliente.getEndereco().setComplemento(requestCliente.getEndereco().getComplemento());

			cliente.setId(UUID.randomUUID());
			cliente.setNome(requestCliente.getNome());
			cliente.setCpf(requestCliente.getCpf());
			cliente.setDataNasc(LocalDate.parse(requestCliente.getDataNasc()));
			cliente.setTelefone(requestCliente.getTelefone());
			// cliente.setClienteAtivo(false);

			// var clienteRepository = new ClienteRepository();
			// clienteRepository.insert(cliente, cliente.getEndereco());

			return ResponseEntity.status(201).body("Cliente salvo no banco de dados");

		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Erro interno do servidor: " + e.getMessage());
		}
	}
}
