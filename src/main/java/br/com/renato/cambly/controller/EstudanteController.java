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

import br.com.renato.cambly.controller.dto.estudante.DadosAtualizacaoEstudanteDto;
import br.com.renato.cambly.controller.dto.estudante.DadosCadastroEstudanteDto;
import br.com.renato.cambly.controller.dto.estudante.DadosDetalhamentoEstudanteDto;
import br.com.renato.cambly.domain.Estudante;
import br.com.renato.cambly.repository.EstudanteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RequestMapping("/estudante")
@RestController
public class EstudanteController {

	@Autowired
	private EstudanteRepository estudanteRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoEstudanteDto> cadastrarEstudante(@RequestBody @Valid DadosCadastroEstudanteDto cadastroEstudanteDto, 
			UriComponentsBuilder uriComponentsBuilder) {
		Estudante estudante = new Estudante(cadastroEstudanteDto);
		estudanteRepository.save(estudante);
		var uri = uriComponentsBuilder.path("/estudante/{id}").buildAndExpand(estudante.getId()).toUri();
		
		DadosDetalhamentoEstudanteDto detalhesEstudante = new DadosDetalhamentoEstudanteDto
				(estudante.getNome(), estudante.getEndereco().getPais(), estudante.getEndereco().getCidade(), estudante.getEmail(), estudante.getTelefone());
		
		return ResponseEntity.created(uri).body(detalhesEstudante);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosDetalhamentoEstudanteDto> detalharEstudante(@PathVariable Long id){
		Estudante estudante = estudanteRepository.getReferenceById(id);
		DadosDetalhamentoEstudanteDto detalhesEstudanteDto = new DadosDetalhamentoEstudanteDto(estudante.getNome(), estudante.getEndereco().getPais(), estudante.getEndereco().getCidade(), estudante.getEmail(), estudante.getTelefone());
		return ResponseEntity.ok(detalhesEstudanteDto);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<DadosDetalhamentoEstudanteDto> atualizarEstudante(@PathVariable Long id, @Valid @RequestBody DadosAtualizacaoEstudanteDto dadosAtualizacaoEstudanteDto){
		System.out.println(id);
		Estudante estudante = estudanteRepository.getReferenceById(id);
		estudante.atualizarInformacoes(dadosAtualizacaoEstudanteDto);
		estudanteRepository.save(estudante);
		return ResponseEntity
				.ok(new DadosDetalhamentoEstudanteDto(estudante.getNome(), estudante.getEndereco().getPais(), estudante.getEndereco().getCidade(), estudante.getTelefone(), estudante.getEmail()));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> excluirEstudante(@PathVariable Long id){
		Estudante estudante = estudanteRepository.getReferenceById(id);
		estudante.excluirLogicamente();
		return ResponseEntity.noContent().build();
	}
}
