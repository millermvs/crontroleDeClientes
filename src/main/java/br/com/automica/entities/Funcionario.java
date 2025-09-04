package br.com.automica.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Funcionario {

	private String nome;
	private String dataNasc;
	private String cpf;
	private String telefone;
	private Endereco endereco;
	private Boolean aindaEhFuncionario;

}
