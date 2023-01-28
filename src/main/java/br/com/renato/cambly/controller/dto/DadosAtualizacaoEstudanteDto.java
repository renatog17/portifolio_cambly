package br.com.renato.cambly.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoEstudanteDto(
		@NotBlank
		String email, 
		@NotBlank
		String telefone, 
		@NotBlank
		String cidade, 
		@NotBlank
		String pais) {

}
