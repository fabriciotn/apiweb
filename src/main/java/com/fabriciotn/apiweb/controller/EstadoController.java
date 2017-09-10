package com.fabriciotn.apiweb.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabriciotn.apiweb.model.Estado;
import com.fabriciotn.apiweb.service.EstadoService;

@RestController
public class EstadoController {

	@Autowired
	EstadoService estadoService;
	
	@RequestMapping(method=RequestMethod.POST, 
			value = "/estados", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> cadastrarEstado(@RequestBody Estado estado){
		Estado estadoCadastrado = estadoService.cadatrar(estado);
		return new ResponseEntity<>(estadoCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value= "/estados", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Estado>> buscarTodosEstados(){
		Collection<Estado> todosEstados = estadoService.buscarTodos();
		return new ResponseEntity<>(todosEstados, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value= "/estados/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> buscarPorId(@PathVariable Integer id){
		Estado estado = estadoService.buscarPorId(id);
		return new ResponseEntity<>(estado, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/estados/{id}")
	public ResponseEntity<Estado> exluirEstado(@PathVariable Integer id){
		Estado estado = estadoService.buscarPorId(id);
		
		if(estado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		estadoService.excluir(estado);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			value = "/estados", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> alterarEstado(@RequestBody Estado estado){
		Estado estadoCadastrado = estadoService.alterar(estado);
		return new ResponseEntity<>(estadoCadastrado, HttpStatus.CREATED);
	}
}
