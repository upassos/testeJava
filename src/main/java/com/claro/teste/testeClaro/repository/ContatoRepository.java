package com.claro.teste.testeClaro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claro.teste.testeClaro.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, String> {

}
