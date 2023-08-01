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

import br.com.springboot.springboot.model.User;
import br.com.springboot.springboot.repository.UserRepository;
import br.com.springboot.springboot.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> buscarPorId(@PathVariable("id") Integer id) {
		 Optional<User> user = userService.buscarPorId(id);
		 
		 return user.isPresent() ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
	}
	
	/*
	@GetMapping("/{id}")
	public User usuario(@PathVariable("id") Integer id){
		Optional<User> userFind = this.userRepository.findById(id);
		
		if(userFind.isPresent()) {
			return userFind.get();
		}
		return null;
	}
	*/

	@PostMapping("/")
	public ResponseEntity<User> salvar(@Valid @RequestBody User usuario) {
		
		User usuarioSalvo = userService.salvar(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}


	@GetMapping("/list")
	public List<User> listarTodos() {
		
		return userService.listarTodos();
	} 

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {

        userService.deletar(id);
    }

	 @GetMapping("/findByName/{name}")
	 public User listMoreThanList(@PathVariable("name") String name) {
		
		return this.userRepository.findByNameIgnoreCase(name);
	}

	@GetMapping("/findByid/{id}")
	public List<User> listGreaterThan(@PathVariable("id") Integer id){

		return this.userRepository.findByIdGreaterThan(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> atualizar(@PathVariable Integer id, @RequestBody User usuario) {
		return ResponseEntity.ok(userService.atualizar(id, usuario));
	}
}
