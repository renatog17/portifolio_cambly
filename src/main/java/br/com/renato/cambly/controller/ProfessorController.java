package br.com.renato.cambly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.renato.cambly.controller.dto.professor.DadosAtualizacaoProfessorDto;
import br.com.renato.cambly.controller.dto.professor.DadosCadastroProfessorDto;
import br.com.renato.cambly.controller.dto.professor.DadosDetalhamentoProfessorDto;
import br.com.renato.cambly.domain.Professor;
import br.com.renato.cambly.repository.ProfessorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RequestMapping("/professor")
@RestController
public class ProfessorController {

	@Autowired
	ProfessorRepository professorRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrarProfessor(@Valid @RequestBody DadosCadastroProfessorDto dadosCadastro, UriComponentsBuilder uriComponentsBuilder){
		Professor professor = new Professor(dadosCadastro);
		professorRepository.save(professor);
		var uri = uriComponentsBuilder.path("/professor/{id}").buildAndExpand(professor.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoProfessorDto(professor));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosDetalhamentoProfessorDto> detalharProfessor(@PathVariable Long id){
		Professor professor = professorRepository.getReferenceById(id);
		return ResponseEntity.ok(new DadosDetalhamentoProfessorDto(professor));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> atualizarProfessor(@PathVariable Long id, @RequestBody DadosAtualizacaoProfessorDto dadosAtualizacao){		
		Professor professor = professorRepository.getReferenceById(id);
		professor.atualizarIfornmacoes(dadosAtualizacao);
		return ResponseEntity.ok(new DadosDetalhamentoProfessorDto(professor));
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletetarProfessor(@PathVariable Long id){
		Professor professor = professorRepository.getReferenceById(id);
		professor.excluirLogicamente();
		return ResponseEntity.noContent().build();
	}
	
	
}
