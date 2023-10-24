package br.com.springboot.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.springboot.springboot.exception.RegraNegocioExecption;
import br.com.springboot.springboot.model.Aluno;
import br.com.springboot.springboot.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	public Aluno salvar(Aluno novoAluno) {
		validarAlunoDuplicado(novoAluno);
		return alunoRepository.save(novoAluno);	
	}
	
	public List<Aluno> listarTodos() {
		
		return alunoRepository.findAll();
	}
	
	public Optional<Aluno> buscarPorId(Integer id) {
		
		return alunoRepository.findById(id);
	}
	
	public Aluno atualizar(Integer id, Aluno aluno) {
		
		Aluno alunoExistente = validarAlunoExiste(id);
		validarAlunoDuplicado(aluno);
		BeanUtils.copyProperties(aluno, alunoExistente, "id");
		
		return alunoRepository.save(alunoExistente);
	}

	private Aluno validarAlunoExiste(Integer id) {
		
		Optional<Aluno> aluno = buscarPorId(id);
		if(aluno.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return aluno.get();
	}
	
	public void deletar(Integer id) {
		
		alunoRepository.deleteById(id);
	}
	
	public void validarAlunoDuplicado(Aluno aluno) {
		
		Aluno alunoEncontrado = alunoRepository.findByNomeAndCpf(aluno.getNome(), aluno.getCpf());
		
		if(alunoEncontrado != null && alunoEncontrado.getCpf() != aluno.getCpf()) {
			throw new RegraNegocioExecption(
				String.format("O aluno %s já está cadastrado", aluno.getNome().toUpperCase()));
		}
	}
	
	public Aluno buscarPeloNome(Aluno aluno) {
	
		return null;
	}
}
