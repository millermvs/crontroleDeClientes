package br.com.automica.entities;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Cliente {
	private UUID id;
	private String nome;
	private String cpf;
	private LocalDate dataNasc;
	private String telefone;
	private Endereco endereco;
	private Boolean clienteAtivo;
}
