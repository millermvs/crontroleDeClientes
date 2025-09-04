package br.com.automica.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.automica.entities.Endereco;
import br.com.automica.entities.Funcionario;

@RestController
@RequestMapping("/api/v1/funcionario")
public class FuncionarioController {

	@PostMapping
	public ResponseEntity<?> post(@RequestBody Funcionario requestFuncionario) {

		try {

			var funcionario = new Funcionario();

			funcionario.setNome(requestFuncionario.getNome());
			funcionario.setCpf(requestFuncionario.getCpf());
			funcionario.setDataNasc(requestFuncionario.getDataNasc());
			funcionario.setTelefone(requestFuncionario.getTelefone());

			funcionario.setEndereco(new Endereco());

			funcionario.getEndereco().setCep(requestFuncionario.getEndereco().getCep());
			funcionario.getEndereco().setRua(requestFuncionario.getEndereco().getRua());
			funcionario.getEndereco().setNumero(requestFuncionario.getEndereco().getNumero());
			funcionario.getEndereco().setBairro(requestFuncionario.getEndereco().getBairro());
			funcionario.getEndereco().setCidade(requestFuncionario.getEndereco().getCidade());
			funcionario.getEndereco().setEstado(requestFuncionario.getEndereco().getEstado());
			funcionario.getEndereco().setPais(requestFuncionario.getEndereco().getPais());
			funcionario.getEndereco().setComplemento(requestFuncionario.getEndereco().getComplemento());

			return ResponseEntity.ok("Funcionário salvo no banco de dados");

		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Erro interno do servidor: " + e.getMessage());
		}

	}

}
