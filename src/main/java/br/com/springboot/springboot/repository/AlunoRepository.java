package br.com.springboot.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.springboot.model.Aluno;
import br.com.springboot.springboot.model.Matricula;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
    
    public List<Aluno> findByIdGreaterThan(Integer id);
	public void save(Matricula matricula);
	public Aluno findByNameIgnoreCase(String name);
	public Aluno findByNameAndCpf(String name, String cpf);


}
