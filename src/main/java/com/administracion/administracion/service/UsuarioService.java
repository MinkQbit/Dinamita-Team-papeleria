package com.administracion.administracion.service;

import java.util.List;
import java.util.Optional;

import com.administracion.administracion.model.Usuario;

public interface UsuarioService {
	public List<Usuario> consultarUsuarios();

	public Optional<Usuario> consultarUsuarioPorId(Long id);

	public Optional<Usuario> consultarUsuarioPorNumero(Long telephoneNumber);

	public Usuario guardarUsuario(Usuario usuario);

	public void eliminarUsuarioPorId(Long id);

}