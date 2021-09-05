package com.claro.teste.testeClaro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.claro.teste.testeClaro.service.ContatoService;
import com.claro.teste.testeClaro.service.dto.ContatoDto;
import com.claro.teste.testeClaro.service.dto.EnderecoDto;
import com.claro.teste.testeClaro.service.mapper.ContatoMapper;
import com.claro.teste.testeClaro.repository.ContatoRepository;

@Service
@Transactional
public class ContatoServiceImpl implements ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private ContatoMapper contatoMapper;
	
	@Autowired
	private WebClient.Builder webClient;
	
	@Override
	public List<ContatoDto> getContatoAll() {

		return contatoMapper.toDto(contatoRepository.findAll());
	}

	@Override
	public EnderecoDto getEndereco(String cep) {
		return webClient.build()
				.get()
				.uri("https://ws.apicep.com/cep.json?code="+cep)
				.retrieve()
				.bodyToMono(EnderecoDto.class)
				.block();
	}

}
