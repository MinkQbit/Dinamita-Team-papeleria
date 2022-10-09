package com.administracion.administracion.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.administracion.model.Usuario;
import com.administracion.administracion.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repositorio;

	@Override
	@Transactional
	public List<Usuario> consultarUsuarios() {
		return repositorio.findAll();
	}

	@Override
	@Transactional
	public Optional<Usuario> consultarUsuarioPorId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	@Transactional
	public Optional<Usuario> consultarUsuarioPorNumero(Long telephoneNumber) {
		return repositorio.findById(telephoneNumber);
	}

	@Override
	@Transactional
	public Usuario guardarUsuario(Usuario usuario) {
		return repositorio.save(usuario);
	}

	@Override
	@Transactional
	public void eliminarUsuarioPorId(Long id) {
		repositorio.deleteById(id);

	}

}
