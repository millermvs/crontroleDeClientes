package br.com.automica.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarClienteRequestDto {

	@Pattern(regexp = "^[A-Za-zÀ-Üà-ü\\s]{3,100}$", message = "O nome só pode ter letras e espaços e deve conter no mínio 3 caracteres")
	@NotEmpty(message = "O campo não pode estar vazio")
	private String nome;

	@Pattern(regexp = "^\\d{11}$", message = "Deve conter 11 números. Ex.: 12345678901")
	@NotEmpty(message = "O campo não pode estar vazio")
	private String cpf;

	@Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$", message = "Deve ser neste formato. Ex.: 1990-05-15")
	@NotEmpty(message = "O campo não pode estar vazio")
	private String dataNasc;

	@Pattern(regexp = "^\\d{2}\\d{2}\\d{8,9}$", message = "Deve conter 12 ou 13 números. Ex.: 5521000000000")
	@NotEmpty(message = "O campo não pode estar vazio")
	private String whatsapp;

	@Pattern(regexp = ("^\\d{8}$"), message = "Deve conter oito números. Ex.: 12345678")
	@NotEmpty(message = "O campo não pode estar vazio")
	private String cep;

	@Pattern(regexp = "^[A-Za-zÀ-Üà-ü\\s]{1,100}$", message = "O nome só pode ter letras e espaços e deve conter de 1 até 100 caracteres.")
	private String rua;

	@Pattern(regexp = "^\\d{1,10}$", message = "No máximo 10 dígitos")
	@NotEmpty(message = "O campo não pode estar vazio")
	private String numero;

	@Pattern(regexp = "^[A-Za-zÀ-Üà-ü\\s]{1,100}$", message = "O nome do bairro só pode ter letras e espaços e deve conter de 1 até 100 caracteres.")
	@NotEmpty(message = "O campo não pode estar vazio")
	private String bairro;

	@Pattern(regexp = "^[A-Za-zÀ-Üà-ü\\s]{1,100}$", message = "O nome da cidade só pode ter letras e espaços e deve conter de 1 até 100 caracteres.")
	@NotEmpty(message = "O campo não pode estar vazio")
	private String cidade;

	@Pattern(regexp = "^[A-Z]{2}$", message = "O nome do estado só pode ter duas letras maiúsculas sem espaços. Ex.: RJ")
	@NotEmpty(message = "O campo não pode estar vazio")
	private String estado;

	@Pattern(regexp = "^[A-Za-zÀ-Üà-ü\\s]{1,100}$", message = "O nome do país só pode ter letras e espaços e deve conter de 1 até 100 caracteres.")
	@NotEmpty(message = "O campo não pode estar vazio")
	private String pais;

	private String complemento;

}
