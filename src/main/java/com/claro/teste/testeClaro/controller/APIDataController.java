package com.claro.teste.testeClaro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.claro.teste.testeClaro.service.ContatoService;
import com.claro.teste.testeClaro.service.dto.ContatoDto;
import com.claro.teste.testeClaro.service.dto.EnderecoDto;

@RestController
@RequestMapping("/APIData")
public class APIDataController {

	@Autowired
	private ContatoService contatoService;
	
	@CrossOrigin
	@GetMapping("/listaContatos")
	public List<ContatoDto> listaContatos() {
		return contatoService.getContatoAll();
	}
	
	@CrossOrigin
	@GetMapping("/recuperaCep/{cep}")
	public EnderecoDto recuperaCep(@PathVariable String cep) {
		return contatoService.getEndereco(cep);
	}
}
