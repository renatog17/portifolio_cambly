package br.com.renato.cambly.domain;

import java.util.List;

import br.com.renato.cambly.controller.dto.professor.DadosAtualizacaoProfessorDto;
import br.com.renato.cambly.controller.dto.professor.DadosCadastroProfessorDto;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "professores")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Professor {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Enumerated(EnumType.STRING)
	private Sotaques sotaque;
	private String email;
	private String cpf;
	private String telefone;
	private boolean ativo = true;
	@OneToMany(mappedBy = "professor")
	private List<Agendamento> agendamentos;
	@Embedded
	private Endereco endereco;
	
	public Professor(DadosCadastroProfessorDto dadosCadastro) {
		this.nome = dadosCadastro.nome();
		this.sotaque = dadosCadastro.sotaque();
		this.email = dadosCadastro.email();
		this.telefone = dadosCadastro.telefone();
		this.endereco = new Endereco(dadosCadastro.endereco());
		this.cpf = dadosCadastro.cpf();
	}

	public void atualizarIfornmacoes(DadosAtualizacaoProfessorDto dadosAtualizacao) {
		this.email = dadosAtualizacao.email();
		this.telefone = dadosAtualizacao.telefone();
		this.endereco.atualizarInformacoes(dadosAtualizacao.cidade(), dadosAtualizacao.email());
	}

	public void excluirLogicamente() {
		this.ativo = false;
		
	}
}
