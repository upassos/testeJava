package com.claro.teste.testeClaro.service;

import java.util.List;

import com.claro.teste.testeClaro.model.Contato;
import com.claro.teste.testeClaro.service.dto.ContatoDto;
import com.claro.teste.testeClaro.service.dto.EnderecoDto;

public interface ContatoService {
	
	public List<ContatoDto> getContatoAll();
	
	public ContatoDto registraContato(ContatoDto novoContato);
	
	public ContatoDto alteraContato(ContatoDto novoContato, String email);
	
	public EnderecoDto getEndereco(String cep);
	
	public ContatoDto getContato(String email);
	
	public void deleteContato(String email);

}
