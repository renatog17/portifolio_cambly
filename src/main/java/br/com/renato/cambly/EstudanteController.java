package br.com.renato.cambly;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/estudante")
public class EstudanteController {

	@PostMapping()
	public ResponseEntity cadastrarEstudante() {
		return ResponseEntity.ok().build();
	}
}
