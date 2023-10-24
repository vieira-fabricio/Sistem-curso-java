package br.com.springboot.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.springboot.springboot.exception.RegraNegocioExecption;
import br.com.springboot.springboot.model.Curso;
import br.com.springboot.springboot.model.Matricula;
import br.com.springboot.springboot.repository.CursoRepository;
import br.com.springboot.springboot.repository.MatriculaRepository;

@Service
public class MatriculaService {
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	@Autowired
	private CursoRepository cursosExistentes;
	
	public Matricula salvar(Matricula matricula, Curso curso) {
		
		validarMatriculaDuplicada(matricula);
		validarCursoExiste(matricula, curso);
		
		return matriculaRepository.save(matricula);
	}
	
	

	public List<Matricula> listarTodas() {
		
		return matriculaRepository.findAll();
	}
	
	public Optional<Matricula> buscarPeloId(Integer id) {
		
		return matriculaRepository.findById(id);
	}
	
	public Matricula atualizar(Integer id, Matricula matricula) {
		
		Matricula matriculaExistente = validarMatriculaExiste(id);
		
		BeanUtils.copyProperties(matricula, matriculaExistente, "id");
		
		return matriculaRepository.save(matriculaExistente);
	}
	
	public void deletar(Integer id) {
		
		matriculaRepository.deleteById(id);
	}
	
	public List<Matricula> buscarPeloNomeAluno(String matricula) {
		
		return matriculaRepository.findByAluno(matricula);
	}
	
	
	//metódps 
	
	private Matricula validarMatriculaExiste(Integer id) {
		
		Optional<Matricula> matricula = buscarPeloId(id);
		if(matricula.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		} else {
			return matricula.get();
		} 
	}

	private void validarMatriculaDuplicada(Matricula matricula) {
		
		Matricula matriculaSalva = matriculaRepository.findByAlunoAndCurso(matricula.getAluno(), matricula.getCurso());
		if(matriculaSalva != null && matriculaSalva.getAluno() != matricula.getAluno()) {
			throw new RegraNegocioExecption(
					String.format("A matricula do aluno %s já existe", matricula.getAluno()));
		}
	}
	
	
	private void validarCursoExiste(Matricula matricula, Curso curso) {
		
		if(matricula == null) {
			throw new IllegalArgumentException("A matrícula não pode ser nula.");
		}
		
		String cursoNome = matricula.getCurso();
	    System.out.println("Nome do Curso: " + cursoNome);
		
		Curso cursoExistente = cursosExistentes.findByNomeIgnoreCase(curso.getNome());
		if(cursoExistente == null || cursoExistente.getNome() == null || cursoExistente.getNome().isEmpty()) {
			System.out.println("Curso Existente: " + cursoExistente);
			throw new RegraNegocioExecption(
					String.format("O curso %s não existe", matricula.getCurso()));
		}
		
	}
}
