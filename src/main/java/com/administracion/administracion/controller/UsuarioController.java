package com.administracion.administracion.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.administracion.administracion.model.Usuario;
import com.administracion.administracion.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService servicioUsuarios;

	@GetMapping
	public ResponseEntity<?> getUsuarios() {
		return ResponseEntity.ok(servicioUsuarios.consultarUsuarios());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUsuarioById(@PathVariable Long id) {
		return ResponseEntity.ok(servicioUsuarios.consultarUsuarioPorId(id));
	}

	@GetMapping("/{telephoneNumber}")
	public ResponseEntity<?> getUsuarioByPhone(@PathVariable Long telephoneNumber) {
		return ResponseEntity.ok(servicioUsuarios.consultarUsuarioPorNumero(telephoneNumber));
	}

	@PostMapping
	public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(servicioUsuarios.guardarUsuario(usuario));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario, @PathVariable Long id) {
		Optional<Usuario> respuesta = servicioUsuarios.consultarUsuarioPorId(id);
		if (respuesta.isPresent()) {
			return ResponseEntity.ok(servicioUsuarios.guardarUsuario(usuario));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
		Optional<Usuario> respuesta = servicioUsuarios.consultarUsuarioPorId(id);
		if (respuesta.isPresent()) {
			servicioUsuarios.consultarUsuarioPorId(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
