package br.com.renato.cambly.controller.dto.professor;

import br.com.renato.cambly.controller.dto.endereco.DadosCadastroEnderecoDto;
import br.com.renato.cambly.domain.Sotaques;

public record DadosCadastroProfessorDto(
		String cpf,
		String nome,
		String email,
		Sotaques sotaque,
		String telefone,
		DadosCadastroEnderecoDto endereco
		) {

	

}
