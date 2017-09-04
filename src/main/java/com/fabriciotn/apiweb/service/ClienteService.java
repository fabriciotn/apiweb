package com.fabriciotn.apiweb.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabriciotn.apiweb.model.Cliente;
import com.fabriciotn.apiweb.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente cadatrar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Collection<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}
	
	public Cliente buscarPorId(Integer id) {
		return clienteRepository.findOne(id);
	}
	
	public void excluir(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
	public Cliente alterar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
