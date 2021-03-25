package com.devgiovani.loja.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devgiovani.loja.domain.Cliente;
import com.devgiovani.loja.repository.ClienteRepository;
import com.devgiovani.loja.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente getById(Integer id) {
		Optional<Cliente> clienteEncontrado = clienteRepository.findById(id);
		return clienteEncontrado.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID:" + id + ", tipo:" + Cliente.class.getName()));
	}
}
