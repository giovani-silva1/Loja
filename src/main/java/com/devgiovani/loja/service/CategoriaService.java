package com.devgiovani.loja.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devgiovani.loja.domain.Categoria;
import com.devgiovani.loja.repository.CategoriaRepository;
import com.devgiovani.loja.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria find(Integer id) {
		Optional<Categoria> categoriaEncontrada = categoriaRepository.findById(id);
		return categoriaEncontrada.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! ID:" + id + ", tipo:" + Categoria.class.getName()));
	}
}
