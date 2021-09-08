package com.claro.teste.testeClaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.claro.teste.testeClaro.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, String> {

	Contato findByEmail(String email);
}
