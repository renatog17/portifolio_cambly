package br.com.renato.cambly.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroEnderecoDto(
		@NotBlank
		String pais, 
		@NotBlank
		String cidade) {

}
