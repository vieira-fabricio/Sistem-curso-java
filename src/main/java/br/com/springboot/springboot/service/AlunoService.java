package br.com.springboot.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.springboot.dto.NovoAluno;
import br.com.springboot.springboot.model.Aluno;
import br.com.springboot.springboot.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	public void save(NovoAluno novoAluno) {
		Aluno aluno = new Aluno();
		aluno.setCpf(novoAluno.getCpf());
		aluno.setName(novoAluno.getName());
		
		
		alunoRepository.save(aluno);
		
	}
}
