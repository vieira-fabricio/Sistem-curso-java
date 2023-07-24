package br.com.springboot.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import br.com.springboot.springboot.exception.RegraNegocioExecption;
import br.com.springboot.springboot.model.User;
import br.com.springboot.springboot.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User salvar(User novoUsuario) {
		validarUsuarioDuplicado(novoUsuario);

		return userRepository.save(novoUsuario);
	}

	public List<User> listarTodos() {

		return userRepository.findAll();
	}

	public Optional<User> buscarPorId(Integer id) {

		return userRepository.findById(id);
	}

	public User atualizar(Integer id, User usuario) {
		User usuarioExistente = validarUsuarioExiste(id);
		validarUsuarioDuplicado(usuario);
		BeanUtils.copyProperties(usuario, usuarioExistente, "id");
		return userRepository.save(usuarioExistente);
	}

	private User validarUsuarioExiste(Integer id) {
		Optional<User> usuario = buscarPorId(id);

		if (usuario.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		} else {
			return usuario.get();
		}
	}

	public void deletar(Integer id) {
		userRepository.deleteById(id);
	}

	private void validarUsuarioDuplicado(User usuario) {

		User usuarioEncontrado = userRepository.findByNameAndUserName(usuario.getName(), usuario.getUserName());
		if (usuarioEncontrado != null && usuarioEncontrado.getId() != usuario.getId()) {
			throw new RegraNegocioExecption(
					String.format("O usuário %s já está cadastrado", usuario.getName(), usuario.getUserName()));
		}
	}
}