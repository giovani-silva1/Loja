package com.devgiovani.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devgiovani.loja.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
