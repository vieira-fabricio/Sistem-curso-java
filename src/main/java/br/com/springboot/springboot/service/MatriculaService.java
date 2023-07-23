package br.com.springboot.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.springboot.dto.NovaMatricula;
import br.com.springboot.springboot.model.Aluno;
import br.com.springboot.springboot.model.Matricula;
import br.com.springboot.springboot.repository.AlunoRepository;

@Service
public class MatriculaService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	public void save(NovaMatricula novaMatricula) {
		Matricula matricula = new Matricula();
		matricula.setCurso(novaMatricula.getAluno());
		matricula.setAluno(novaMatricula.getAluno());
		
		Aluno aluno = (Aluno) alunoRepository.findByNameIgnoreCase(null);
		if(aluno != null) {
			alunoRepository.save(aluno);
		}
		
		alunoRepository.save(matricula);
	}
	
}
