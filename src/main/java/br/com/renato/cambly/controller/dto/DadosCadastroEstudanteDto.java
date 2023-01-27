package br.com.renato.cambly.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroEstudanteDto(
		@NotBlank 
		String nome,
		@NotBlank
		String cpf,
		@Valid
		@NotNull
		DadosCadastroEnderecoDto endereco) {

}
