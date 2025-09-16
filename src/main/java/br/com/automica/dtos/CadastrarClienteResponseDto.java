package br.com.automica.dtos;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CadastrarClienteResponseDto {
	
	private UUID id;
	private String nome;
	private Integer idEndereco;

}
