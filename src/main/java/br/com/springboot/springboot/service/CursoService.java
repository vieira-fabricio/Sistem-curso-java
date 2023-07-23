package br.com.springboot.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.springboot.dto.NovoCurso;
import br.com.springboot.springboot.model.Curso;
import br.com.springboot.springboot.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	public void save(NovoCurso novoCurso) {
		
		Curso curso = new Curso();
		curso.setNome(novoCurso.getNome());
		curso.setDescricao(novoCurso.getDescricao());
		
		cursoRepository.save(curso);
		
	}

}
