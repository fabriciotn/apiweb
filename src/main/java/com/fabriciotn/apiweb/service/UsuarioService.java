package com.fabriciotn.apiweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabriciotn.apiweb.model.Usuario;
import com.fabriciotn.apiweb.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario cadastrar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario buscarPorNome(String nome) {
		return usuarioRepository.buscarPorNome(nome);
	}
}
