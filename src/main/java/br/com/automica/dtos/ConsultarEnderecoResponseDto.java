package br.com.automica.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultarEnderecoResponseDto {

	private Long id;
	private String cep;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	private String complemento;
	
}
