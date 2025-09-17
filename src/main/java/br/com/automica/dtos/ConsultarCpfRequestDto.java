package br.com.automica.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultarCpfRequestDto {
	
	@NotEmpty
	@Pattern (regexp = "^[0-9]{11}$")
	private String cpf;

}
