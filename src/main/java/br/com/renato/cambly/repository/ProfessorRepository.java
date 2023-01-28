package br.com.renato.cambly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.renato.cambly.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
