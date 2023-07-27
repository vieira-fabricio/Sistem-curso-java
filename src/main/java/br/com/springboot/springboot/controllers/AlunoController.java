package br.com.springboot.springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Aluno aluno(@Valid @RequestBody Aluno aluno){
        
        return alunoService.salvar(aluno);
    }

    @GetMapping("/list")
	public List<Aluno> listarTodos() {
		
		return alunoService.listarTodos();
	}

    @GetMapping("/findByName/{name}")
	 public List<Aluno> listMoreThanList(@PathVariable("name") String name) {
		
		return this.alunoRepository.findByNameIgnoreCase(name);
	}

	@GetMapping("/findByid/{id}")
	public List<Aluno> listGreaterThan(@PathVariable("id") Integer id){

		return this.alunoRepository.findByIdGreaterThan(id);
	}

    @DeleteMapping("/{id}")
    public Aluno deletarPeloId(@PathVariable("id") Integer id) {

        if(alunoRepository.existsById(id)){
            alunoRepository.deleteById(id);
        } 
        return null;
    }

}


