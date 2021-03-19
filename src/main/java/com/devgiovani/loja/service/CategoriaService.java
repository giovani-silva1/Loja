package com.devgiovani.loja.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devgiovani.loja.domain.Categoria;
import com.devgiovani.loja.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria find(Integer id) {
		Optional<Categoria> categoriaEncontrada = categoriaRepository.findById(id);
		return categoriaEncontrada.orElse(null);
	}
}
