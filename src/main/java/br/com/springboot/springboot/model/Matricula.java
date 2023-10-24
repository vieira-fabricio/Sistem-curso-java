package br.com.springboot.springboot.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "table_matricula")
public class Matricula{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_matricula")
    private final LocalDate dataMatricula = LocalDate.now();

    @NotBlank(message = "Aluno")
    @Length(min = 3, max = 20, message = "Aluno")
    private String aluno;
    @NotBlank(message = "Curso")
    @Length(min = 3, max = 50, message = "Curso")
    private String curso;
    
    @NotNull
    private Integer id_aluno;
    
    @NotNull
    private Integer id_curso;
   
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDataMatricula() {
		return dataMatricula;
	}
	public String getAluno() {
		return aluno;
	}
	public void setAluno(String aluno) {
		this.aluno = aluno;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getId_aluno() {
		return id_aluno;
	}
	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}
	public int getId_curso() {
		return id_curso;
	}
	public void setId_curso(Integer id_curso) {
		this.id_curso = id_curso;
	}
	
	
	
    
}
