package br.com.springboot.springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.springboot.model.Aluno;
import br.com.springboot.springboot.repository.AlunoRepository;
import br.com.springboot.springboot.service.AlunoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;
    
    @Autowired
    private AlunoService alunoService;

    @GetMapping("/{id}")
    public Optional<Aluno> buscarPorId(@PathVariable("id") Integer id){
 
		return alunoService.buscarPorId(id);
    }

    @PostMapping("/")
    public Aluno salvar(@Valid @RequestBody Aluno aluno){
        
        return alunoService.salvar(aluno);
    }

    @GetMapping("/list")
	public List<Aluno> listarTodos() {
		
		return alunoService.listarTodos();
	}
    
    @GetMapping("/findByName/{name}")
    public Aluno buscarPeloNome(@PathVariable("nome") String nome) {
    	
    	return alunoRepository.findByNomeIgnoreCase(nome);
    }

	@GetMapping("/findByid/{id}")
	public List<Aluno> listGreaterThan(@PathVariable("id") Integer id){

		return this.alunoRepository.findByIdGreaterThan(id);
	}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {

        alunoService.deletar(id);
    }

}


