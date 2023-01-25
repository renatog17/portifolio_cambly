package br.com.renato.cambly.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "medicos")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Professor {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String cidadeDeOrigem;
	private String cidadeAtual;
	private String paisDeOrigem;
	private String paisAtual;
	private String sotaque;
}
