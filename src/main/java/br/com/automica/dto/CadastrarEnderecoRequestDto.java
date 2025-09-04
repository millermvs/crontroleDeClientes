package br.com.automica.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarEnderecoRequestDto {
	
	private UUID id;
	
	@Pattern(regexp = ("^\\d{8}$"), message = "Deve conter oito números. Ex.: 12345678")
	@NotEmpty (message ="O campo não pode estar vazio")
	private String cep;
	
	@Pattern(regexp = "^[A-Za-zÀ-Üà-ü\\s]{1,100}$",	message = "O nome só pode ter letras e espaços e deve conter de 1 até 100 caracteres.")
	private String rua;
	
	@Pattern(regexp = "^\\d{1,10}$", message = "No máximo 10 dígitos")
	@NotEmpty (message ="O campo não pode estar vazio")
	private String numero;
	
	@Pattern(regexp = "^[A-Za-zÀ-Üà-ü\\s]{1,100}$", message = "O nome do bairro só pode ter letras e espaços e deve conter de 1 até 100 caracteres.")
	@NotEmpty (message ="O campo não pode estar vazio")
	private String bairro;
	
	@Pattern(regexp = "^[A-Za-zÀ-Üà-ü\\s]{1,100}$", message = "O nome da cidade só pode ter letras e espaços e deve conter de 1 até 100 caracteres.")
	@NotEmpty (message ="O campo não pode estar vazio")
	private String cidade;
	
	@Pattern(regexp = "^[A-Z]{2}$", message = "O nome do estado só pode ter duas letras maiúsculas sem espaços. Ex.: RJ")
	@NotEmpty (message ="O campo não pode estar vazio")
	private String estado;
	
	@Pattern(regexp = "^[A-Za-zÀ-Üà-ü\\s]{1,100}$", message = "O nome do país só pode ter letras e espaços e deve conter de 1 até 100 caracteres.")
	@NotEmpty (message ="O campo não pode estar vazio")
	private String pais;
	
	private String complemento;
}
