package br.com.automica.dtos;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultarCpfResponseDto {

	private UUID id;
	private String nome;
	private String cpf;

}
