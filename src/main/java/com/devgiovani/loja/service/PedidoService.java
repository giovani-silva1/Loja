package com.devgiovani.loja.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devgiovani.loja.domain.Pedido;
import com.devgiovani.loja.repository.PedidoRepository;
import com.devgiovani.loja.service.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	public Pedido getPedidoById(Integer id) {
		Optional<Pedido> pedidoEncontrado = pedidoRepository.findById(id);
		return pedidoEncontrado.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! ID:" + id + ", tipo:" + Pedido.class.getName()));
	}
}
