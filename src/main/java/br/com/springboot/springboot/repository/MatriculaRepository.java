package br.com.springboot.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.springboot.model.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer>{
    
    public List<Matricula> findByAluno(String aluno);

}
