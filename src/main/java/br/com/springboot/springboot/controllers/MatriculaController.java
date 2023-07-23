package br.com.springboot.springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.springboot.model.Matricula;
import br.com.springboot.springboot.repository.MatriculaRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
    
    @Autowired
    private MatriculaRepository matriculaRepository;

    @GetMapping("/{id}")
    public Matricula matricula(@PathVariable("id") Integer id){

        Optional<Matricula> matriculaFind = this.matriculaRepository.findById(id);
        
        if(matriculaFind.isPresent()) {
			return matriculaFind.get();
		}
		return null;
    }

    @PostMapping("/")
    public Matricula matricula(@RequestBody Matricula matricula){
        
        return this.matriculaRepository.save(matricula);
    }

    @GetMapping("/list")
	public List<Matricula> list() {
		
		return this.matriculaRepository.findAll();
	}

	@GetMapping("/findByAluno/{aluno}")
	public List<Matricula> findByAluno(@PathVariable("aluno") String aluno){

		return this.matriculaRepository.findByAluno(aluno);
	}

    @DeleteMapping("/{id}")
    public Matricula deletarPeloId(@PathVariable("id") Integer id) {

        if(matriculaRepository.existsById(id)){
            matriculaRepository.deleteById(id);
        } 
        return null;
    }

}
