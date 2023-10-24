package br.com.springboot.springboot;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.dao.EmptyResultDataAccessException;

import br.com.springboot.springboot.exception.RegraNegocioExecption;
import br.com.springboot.springboot.model.Curso;
import br.com.springboot.springboot.model.Matricula;
import br.com.springboot.springboot.repository.CursoRepository;


public class AssertionsTeste {
	
	private CursoRepository cursosExistentes;
	

	  @Test 
	  void validarSeCursoExisteNaClasseMatriculaService(Matricula matricula,
	  Curso cursoExisteNoBanco) {
	  
	  String cursoNovo = matricula.getCurso(); System.out.println("Nome do Curso: "
	  + cursoNovo);
	  
	  Curso cursoExistente =
	  cursosExistentes.findByNomeIgnoreCase(cursoExisteNoBanco.getNome());
	  if(cursoExistente == null || cursoExistente.getNome() == null ||
	  cursoExistente.getNome().isEmpty()) { System.out.println("Curso Existente: "
	  + cursoExistente); throw new RegraNegocioExecption(
	  String.format("O curso %s não existe", matricula.getCurso())); } }

	
	@Test   
	void validarCursoExiste(Integer id) {

		Optional<Curso> curso = cursosExistentes.findById(id);
		
		if(curso.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		
	}

}
