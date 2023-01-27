package br.com.renato.cambly.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {

	private String pais;
	private String cidade;
	public String getPais() {
		return pais;
	}
	public String getCidade() {
		return cidade;
	}
	public Endereco(String pais, String cidade) {
		super();
		this.pais = pais;
		this.cidade = cidade;
	}
	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
