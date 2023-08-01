package br.com.springboot.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.springboot.springboot.exception.RegraNegocioExecption;
import br.com.springboot.springboot.model.Curso;
import br.com.springboot.springboot.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	public Curso salvar(Curso novoCurso) {
		
		validarCursoDuplicado(novoCurso);
		return cursoRepository.save(novoCurso);
		
	}
	
	public List<Curso> listarTodos() {
		
		return cursoRepository.findAll();
	}
	
	public Optional<Curso> buscarPeloId(Integer id) {
		
		return cursoRepository.findById(id);
	}
	
	public Curso atualizar(Integer id, Curso curso) {
		
		Curso cursoExistente = validarCursoExiste(id);
		validarCursoDuplicado(curso);
		BeanUtils.copyProperties(curso, cursoExistente, "id");
		
		return cursoRepository.save(cursoExistente);
	}
	
	public void deletar(Integer id) {
		
		cursoRepository.deleteById(id);
	}
	
	public Curso buscarPeloNome(String nome) {
		
		return cursoRepository.findByNomeIgnoreCase(nome);
	}

	//Método para validar se o curso já existe!
	private Curso validarCursoExiste(Integer id) {

		Optional<Curso> curso = buscarPeloId(id);
		
		if(curso.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		} else {
			return curso.get();
		}
		
	}

	//Método para validar se o curso está duplicado
	private void validarCursoDuplicado(Curso novoCurso) {
		
		Curso cursoEncontrato = cursoRepository.findByNomeIgnoreCase(novoCurso.getNome());
		
		if(cursoEncontrato != null && cursoEncontrato.getId() != novoCurso.getId()) {
			throw new RegraNegocioExecption(
					String.format("O curso %s já está cadastrado", novoCurso.getNome()));
		}
	}

}
