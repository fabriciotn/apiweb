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

import com.fabriciotn.apiweb.model.Cliente;
import com.fabriciotn.apiweb.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@RequestMapping(method=RequestMethod.POST, 
			value = "/clientes", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente){
		Cliente clienteCadastrado = clienteService.cadatrar(cliente);
		return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value= "/clientes", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarTodosClientes(){
		Collection<Cliente> todosClientes = clienteService.buscarTodos();
		return new ResponseEntity<>(todosClientes, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value= "/clientes/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id){
		Cliente cliente = clienteService.buscarPorId(id);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/clientes/{id}")
	public ResponseEntity<Cliente> exluirCliente(@PathVariable Integer id){
		Cliente cliente = clienteService.buscarPorId(id);
		
		if(cliente == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		clienteService.excluir(cliente);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			value = "/clientes", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente){
		Cliente clienteCadastrado = clienteService.alterar(cliente);
		return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);
	}
}
