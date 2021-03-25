package com.devgiovani.loja.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devgiovani.loja.domain.Cidade;
import com.devgiovani.loja.repository.CidadeRepository;
import com.devgiovani.loja.service.exception.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade findCidadeById(Integer id) {
		Optional<Cidade> cidadeEncontrada = cidadeRepository.findById(id);
		return cidadeEncontrada.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! ID:" + id + ", tipo:" + Cidade.class.getName()));
	}
}
