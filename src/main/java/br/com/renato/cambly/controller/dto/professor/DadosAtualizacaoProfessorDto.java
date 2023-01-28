package br.com.renato.cambly.controller.dto.professor;


public record DadosAtualizacaoProfessorDto(
		String nome,
		String email,
		String telefone,
		String cidade,
		String pais
		) {

}
