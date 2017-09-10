package com.fabriciotn.apiweb.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabriciotn.apiweb.model.Estado;
import com.fabriciotn.apiweb.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	EstadoRepository estadoRepository;
	
	public Estado cadatrar(Estado estado) {
		return estadoRepository.save(estado);
	}
	
	public Collection<Estado> buscarTodos(){
		return estadoRepository.findAll();
	}
	
	public Estado buscarPorId(Integer id) {
		return estadoRepository.findOne(id);
	}
	
	public void excluir(Estado estado) {
		estadoRepository.delete(estado);
	}
	
	public Estado alterar(Estado estado) {
		return estadoRepository.save(estado);
	}
}
