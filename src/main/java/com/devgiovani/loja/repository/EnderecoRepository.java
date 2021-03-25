package com.devgiovani.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devgiovani.loja.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {

}
