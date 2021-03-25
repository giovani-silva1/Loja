package com.devgiovani.loja.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devgiovani.loja.domain.Cidade;
import com.devgiovani.loja.service.CidadeService;

@RestController
@RequestMapping(value = "/cidades" )
public class CidadeResource {

	
	@Autowired
	CidadeService cidadeService;
	
	
	@RequestMapping(value ="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> findCidade(@PathVariable Integer id){
		Cidade cidade =  cidadeService.findCidadeById(id);
		return ResponseEntity.ok().body(cidade);
	}
}
