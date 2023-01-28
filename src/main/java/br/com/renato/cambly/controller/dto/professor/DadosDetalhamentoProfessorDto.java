package br.com.renato.cambly.controller.dto.professor;

import br.com.renato.cambly.domain.Professor;
import br.com.renato.cambly.domain.Sotaques;

public record DadosDetalhamentoProfessorDto(String email, String nome, String telefone, Sotaques sotaque, String cidade,
		String pais) {

	public DadosDetalhamentoProfessorDto(Professor professor) {
		this(professor.getEmail(), professor.getNome(), professor.getTelefone(), professor.getSotaque(), professor.getEndereco().getCidade(), professor.getEndereco().getPais());
		
	}
}

