package com.claro.teste.testeClaro.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.claro.teste.testeClaro.exception.MensagemErroGenerica;
import com.claro.teste.testeClaro.service.dto.ContatoDto;

@SpringBootTest
public class ContatoServiceTest {

	@Autowired
	private ContatoService contatoService;
	
	@Test
	public void getContatoTest() {
		ContatoDto contatoDto = contatoService.getContato("ubiratan.passos@gmail.com");
		assertNotEquals("", contatoDto.getNome());
		assertNotEquals("", contatoDto.getEmail());
		assertNotEquals("", contatoDto.getTelefone());
		assertNotEquals("", contatoDto.getCep());
		assertNotEquals("", contatoDto.getEndereco());
		assertNotEquals("", contatoDto.getCidade());
		assertNotEquals("", contatoDto.getUf());
		assertNotEquals("", contatoDto.getDataCadastro());
	}

	@Test
	public void getContatoWrongEmailTest() {
		ContatoDto contatoDto = contatoService.getContato("ubiratan.passosgmail.com");
		assertNull(contatoDto);
	}
	
	@Test
	public void postContatoTest() {
		ContatoDto contatoDto = new ContatoDto();
		contatoDto.setEmail("josue.miranda2@gmail.com");
		contatoDto.setNome("Josué Alberto Miranda da Silta Eustachio");
		contatoDto.setTelefone("28999996559");
		contatoDto.setCep("29360-000");
		
		contatoService.registraContato(contatoDto);
		
		assertNotEquals("", contatoDto.getNome());
		assertNotEquals("", contatoDto.getEmail());
		assertNotEquals("", contatoDto.getTelefone());
		assertNotEquals("", contatoDto.getCep());
		assertNotEquals("", contatoDto.getEndereco());
		assertNotEquals("", contatoDto.getCidade());
		assertNotEquals("", contatoDto.getUf());
		assertNotEquals("", contatoDto.getDataCadastro());
	}
	
	@Test
	public void postContatoWrongEmailTest() {
		ContatoDto contatoDto = new ContatoDto();
		contatoDto.setEmail("josue.mirandagmail.com");
		contatoDto.setNome("Josué Alberto Miranda da Silta Eustachio");
		contatoDto.setTelefone("28999996559");
		contatoDto.setCep("29360-000");
		
		MensagemErroGenerica erroGenerico = Assertions.assertThrows(MensagemErroGenerica.class, () -> contatoService.registraContato(contatoDto));

		assertEquals("O endereço de e-mail informado parece não ser válido.", erroGenerico.getMessage());
	}
	
	@Test
	public void putContatoDuplicateEmailTest() {
		ContatoDto contatoDto = new ContatoDto();
		contatoDto.setEmail("josue.miranda@gmail.com");
		contatoDto.setNome("Josué Alberto Miranda da Silta Eustachio");
		contatoDto.setTelefone("28999996559");
		contatoDto.setCep("29360-000");
		
		MensagemErroGenerica erroGenerico = Assertions.assertThrows(MensagemErroGenerica.class, () -> contatoService.registraContato(contatoDto));

		assertEquals("O endereço de email informado já está cadastrado.", erroGenerico.getMessage());
	}
	
	@Test
	public void putContatoTest() {
		ContatoDto contatoDto = new ContatoDto();
		contatoDto.setEmail("josue.miranda2@gmail.com");
		contatoDto.setNome("Josué Alberto Miranda da Silta Eustachio");
		contatoDto.setTelefone("28999996559");
		contatoDto.setCep("29360-000");
		
		contatoService.alteraContato(contatoDto, contatoDto.getEmail());
		
		assertNotEquals("", contatoDto.getNome());
		assertNotEquals("", contatoDto.getEmail());
		assertNotEquals("", contatoDto.getTelefone());
		assertNotEquals("", contatoDto.getCep());
		assertNotEquals("", contatoDto.getEndereco());
		assertNotEquals("", contatoDto.getCidade());
		assertNotEquals("", contatoDto.getUf());
		assertNotEquals("", contatoDto.getDataCadastro());
	}
	
	@Test
	public void putContatoWithoutEmailTest() {
		ContatoDto contatoDto = new ContatoDto();
		contatoDto.setEmail("josue.miranda2@gmail.com");
		contatoDto.setNome("Josué Alberto Miranda da Silta Eustachio");
		contatoDto.setTelefone("28999996559");
		contatoDto.setCep("29360-000");
		
		MensagemErroGenerica erroGenerico = Assertions.assertThrows(MensagemErroGenerica.class, () -> contatoService.alteraContato(contatoDto, ""));

		assertEquals("O campo e-mail deve ser preenchido.", erroGenerico.getMessage());
		
	}
	
	@Test
	public void putContatoWrongEmailTest() {
		ContatoDto contatoDto = new ContatoDto();
		contatoDto.setEmail("josue.miranda2gmail.com");
		contatoDto.setNome("Josué Alberto Miranda da Silta Eustachio");
		contatoDto.setTelefone("28999996559");
		contatoDto.setCep("29360-000");
		
		MensagemErroGenerica erroGenerico = Assertions.assertThrows(MensagemErroGenerica.class, () -> contatoService.alteraContato(contatoDto, ""));

		assertEquals("O endereço de e-mail informado parece não ser válido.", erroGenerico.getMessage());
		
	}
	
	@Test
	public void deleteContatoTest() {
		String email = "josue.miranda2@gmail.com";
		
		MensagemErroGenerica erroGenerico = Assertions.assertThrows(MensagemErroGenerica.class, () -> contatoService.deleteContato(email));

		assertEquals("", erroGenerico.getMessage());
	
	}
	
	@Test
	public void deleteContatoWrongEmailTest() {
		String email = "josue.miranda2gmail.com";
		
		MensagemErroGenerica erroGenerico = Assertions.assertThrows(MensagemErroGenerica.class, () -> contatoService.deleteContato(email));

		assertEquals("O endereço de e-mail informado parece não ser válido.", erroGenerico.getMessage());
	
	}
	
	@Test
	public void deleteContatoWithOutEmailTest() {
		String email = "";
		
		MensagemErroGenerica erroGenerico = Assertions.assertThrows(MensagemErroGenerica.class, () -> contatoService.deleteContato(email));

		assertEquals("O campo e-mail deve ser preenchido.", erroGenerico.getMessage());
		
	}
	
	@Test
	public void deleteNotExistsEmailTest() {
		String email = "";
		
		MensagemErroGenerica erroGenerico = Assertions.assertThrows(MensagemErroGenerica.class, () -> contatoService.deleteContato(email));

		assertEquals("Não existe contato com o e-mail informado.", erroGenerico.getMessage());
		
	}
	
}
