package br.com.automica.dto;

import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarClienteRequestDto {

	private UUID id;

	@Pattern(regexp = "^[A-Za-zÀ-Üà-ü\\s]{3,100}$", message = "O nome só pode ter letras e espaços e deve conter no mínio 3 caracteres")
	@NotEmpty(message = "O campo não pode estar vazio")
	private String nome;

	@Pattern(regexp = "^\\d{11}$", message = "Deve conter 11 números. Ex.: 12345678901")
	@NotEmpty(message = "O campo não pode estar vazio")
	private String cpf;

	@Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$", message = "Deve ser neste formato. Ex.: 1990-05-15")
	@NotEmpty(message = "O campo não pode estar vazio")
	private String dataNasc;

	@Pattern(regexp = "^\\d{2}\\d{2}\\d{8,9}$", message = "Deve conter 12 ou 13 números. Ex.: 5521000000000" )
	@NotEmpty(message = "O campo não pode estar vazio")
	private String telefone;
	
	@Valid
    private CadastrarEnderecoRequestDto endereco;

}
