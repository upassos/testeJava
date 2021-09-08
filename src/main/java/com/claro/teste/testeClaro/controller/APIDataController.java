package com.claro.teste.testeClaro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@PutMapping("/contato/{email}")
	public ContatoDto getContato(@RequestBody ContatoDto novoContato, @PathVariable String email) {
		return contatoService.alteraContato(novoContato, email);
	}
	
	@CrossOrigin
	@PostMapping("/contato")
	public ContatoDto novoContato(@RequestBody ContatoDto novoContato) {
	    return contatoService.registraContato(novoContato);
	  }
	
	@CrossOrigin
	@DeleteMapping("/contato/{email}")
	public void recuperaCep(@PathVariable String email) {
		contatoService.deleteContato(email);
	}
}
