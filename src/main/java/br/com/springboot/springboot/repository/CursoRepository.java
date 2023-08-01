package br.com.springboot.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.springboot.springboot.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
	
	public Curso findByNomeIgnoreCase(String nome);

}
