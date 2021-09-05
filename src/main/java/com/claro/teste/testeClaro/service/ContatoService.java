package com.claro.teste.testeClaro.service;

import java.util.List;

import com.claro.teste.testeClaro.service.dto.ContatoDto;
import com.claro.teste.testeClaro.service.dto.EnderecoDto;

public interface ContatoService {
	
	public List<ContatoDto> getContatoAll();
	
	public EnderecoDto getEndereco(String cep);

}
