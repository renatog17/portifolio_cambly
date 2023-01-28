package br.com.renato.cambly.controller.dto.estudante;

import br.com.renato.cambly.controller.dto.endereco.DadosCadastroEnderecoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroEstudanteDto(
		@NotBlank 
		String nome,
		@NotBlank
		String cpf,
		@NotBlank
		String email,
		@NotBlank
		String telefone,
		@Valid
		@NotNull
		DadosCadastroEnderecoDto endereco) {

}
