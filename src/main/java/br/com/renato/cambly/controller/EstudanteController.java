package br.com.renato.cambly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.renato.cambly.controller.dto.DadosCadastroEstudanteDto;
import br.com.renato.cambly.controller.dto.DadosDetalhamentoEstudanteDto;
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
				(estudante.getNome(), estudante.getEndereco().getPais(), estudante.getEndereco().getCidade());
		
		return ResponseEntity.created(uri).body(detalhesEstudante);
		
	}
}
