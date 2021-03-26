package com.devgiovani.loja.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devgiovani.loja.domain.Pedido;
import com.devgiovani.loja.service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService pedidoService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPedidoById(@PathVariable Integer id) {
		Pedido pedidoEncontrado = pedidoService.getPedidoById(id);
		return ResponseEntity.ok().body(pedidoEncontrado);
	}

}
