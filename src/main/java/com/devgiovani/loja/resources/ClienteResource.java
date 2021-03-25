package com.devgiovani.loja.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devgiovani.loja.domain.Cliente;
import com.devgiovani.loja.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value ="/{id}",method = RequestMethod.GET)
	private ResponseEntity<?> findById(@PathVariable Integer id){
		Cliente clienteEncontrado = clienteService.getById(id);
		return ResponseEntity.ok().body(clienteEncontrado);
	}
}
