package br.com.automica.entities;

import java.util.UUID;

public class Endereco {
	
	private UUID id;
	private String cep;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	private String complemento;

	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public Endereco(UUID id, String cep, String rua, String numero, String bairro, String cidade, String estado, String pais,
			String complemento) {
		this.id = id;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.complemento = complemento;
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", cidade="
				+ cidade + ", estado=" + estado + ", pais=" + pais + ", complemento=" + complemento + "]";
	}

}
