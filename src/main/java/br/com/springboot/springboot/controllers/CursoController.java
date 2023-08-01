package br.com.springboot.springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.springboot.model.Curso;
import br.com.springboot.springboot.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {
	

	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Curso>> buscarPeloId(@PathVariable("id") Integer id) {
		
		Optional<Curso> cursoFind = cursoService.buscarPeloId(id);
		
		 return cursoFind.isPresent() ? ResponseEntity.ok(cursoFind) : ResponseEntity.notFound().build();	
	}
	
	@GetMapping("/buscarPeloNome/{nome}")
	public Curso buscarPeloNome(String nome) {
		
		return cursoService.buscarPeloNome(nome);
	}
	
	@PostMapping("/")
	public ResponseEntity<Curso> salvar(@RequestBody Curso curso) {
		
		Curso cursoSalvo = cursoService.salvar(curso);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cursoSalvo);
	}
	
	@GetMapping("/list")
	public List<Curso> listartodos() {
		
		return this.cursoService.listarTodos();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable("id") Integer id) {
		
		cursoService.deletar(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Curso> atualizar(@PathVariable Integer id,  @RequestBody Curso curso) {
		
		return ResponseEntity.ok(cursoService.atualizar(id, curso));
	}
	

}
