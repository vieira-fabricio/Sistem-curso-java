package br.com.springboot.springboot.model;


import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "table_alunos")
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome")
    @NotBlank(message = "Nome")
    @Length(min = 3, max = 50, message = "Nome")
    private String nome;
    @Column(name="cpf")
    @NotBlank(message = "CPF")
    @Length(min = 11, max = 11, message = "CPF")
    private String cpf;
    
    @NotBlank(message = "Rua")
    @Length(min = 3, max = 50, message = "Rua")
    private String rua;
    
    @NotBlank(message = "Numero")
    @Length(min = 1, max = 5, message = "Numero")
    private String numero;
    
    @NotBlank(message = "CEP")
    @Length(min = 8, max = 8, message = "CEP")
    private String cep;
    
    @NotBlank(message = "Bairro")
    @Length(min = 3, max = 50, message = "Bairro")
    private String bairro;
    
    @NotBlank(message = "Cidade")
    @Length(min = 3, max = 50, message = "Cidade")
    private String cidade;
    
    @NotBlank(message = "Estado")
    @Length(min = 3, max = 20, message = "Cidade")
    private String estado;
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rua=" + rua + ", numero=" + numero + ", cep="
				+ cep + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + "]";
	}
	
	
	

}
