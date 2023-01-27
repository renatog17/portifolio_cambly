package br.com.renato.cambly.domain;

import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "estudantes")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of="id")
public class Estudante {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long nome;
	private String cpf;
	@Embedded
	private Endereco endereco;
	@OneToMany(mappedBy = "estudante")
	private List<Agendamento> agendamentos;
}
