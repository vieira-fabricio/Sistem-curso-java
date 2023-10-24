package br.com.springboot.springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.springboot.model.Curso;
import br.com.springboot.springboot.model.Matricula;
import br.com.springboot.springboot.service.MatriculaService;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
    
    @Autowired
    private MatriculaService matriculaService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Matricula>> BuscarPeloId(@PathVariable("id") Integer id){

        Optional<Matricula> matriculaFind = matriculaService.buscarPeloId(id);
        
		return matriculaFind.isPresent() ? ResponseEntity.ok(matriculaFind) : ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Matricula> salvar(@Valid @RequestBody Matricula matricula, Curso curso){
    	
    	Matricula matriculaSalva = matriculaService.salvar(matricula, curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(matriculaSalva);
    }

    @GetMapping("/list")
	public List<Matricula> listartodas() {
		
		return matriculaService.listarTodas();
	}
	
	@GetMapping("/findByAluno/{aluno}")
	public List<Matricula> buscarPeloNomeAluno(@PathVariable String aluno) {
		
		return matriculaService.buscarPeloNomeAluno(aluno);
	}

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Integer id) {

       matriculaService.deletar(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Matricula> atualizar(@PathVariable Integer id, @RequestBody Matricula matricula) {
    	
    	return ResponseEntity.ok(matriculaService.atualizar(id, matricula));
    }

}
