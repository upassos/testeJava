package com.claro.teste.testeClaro.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.claro.teste.testeClaro.exception.MensagemErroGenerica;
import com.claro.teste.testeClaro.service.ContatoService;
import com.claro.teste.testeClaro.service.dto.ContatoDto;
import com.claro.teste.testeClaro.service.dto.EnderecoDto;

@Service
@Transactional
public class ContatoValidator {

	@Autowired
	private ContatoService contatoService;
	
	public EnderecoDto validaCEP(String cep) {
		
		if (cep.trim().equals("")) {
			throw new MensagemErroGenerica("O campo CEP deve ser preenchido.");
		}else {
			EnderecoDto enderecoDto = new EnderecoDto();
			enderecoDto = contatoService.getEndereco(cep);
			if (enderecoDto.isOk() == false) {
				throw new MensagemErroGenerica("O CEP informado não é válido.");
			}
			return enderecoDto;
		}
	}
	
	public boolean validaCamposContato(ContatoDto novoContato) {
		if (novoContato.getEmail().trim().equals("")) {
			throw new MensagemErroGenerica("O campo e-mail deve ser preenchido.");
		}
		if (!novoContato.getEmail().contains("@")) {
			throw new MensagemErroGenerica("O endereço de e-mail informado parece não ser válido.");
		}
		if (novoContato.getNome().trim().equals("")) {
			throw new MensagemErroGenerica("O campo nome deve ser preenchido.");
		}		
		if (novoContato.getTelefone().trim().equals("")) {
			throw new MensagemErroGenerica("O campo telefone deve ser preenchido.");
		}
		if (novoContato.getTelefone().trim().length() < 8) {
			throw new MensagemErroGenerica("O campo telefone deve ter pelo menos oito dígitos.");
		}
		if (contatoService.getContato(novoContato.getEmail()) != null) {
			throw new MensagemErroGenerica("O endereço de email informado já está cadastrado.");
		}
		return true;
	}
	
	public boolean validaCamposAlteracaoContato(ContatoDto novoContato) {
		if (novoContato.getEmail().trim().equals("")) {
			throw new MensagemErroGenerica("O campo e-mail deve ser preenchido.");
		}
		if (!novoContato.getEmail().contains("@")) {
			throw new MensagemErroGenerica("O endereço de e-mail informado parece não ser válido.");
		}
		if (novoContato.getNome().trim().equals("")) {
			throw new MensagemErroGenerica("O campo nome deve ser preenchido.");
		}		
		if (novoContato.getTelefone().trim().equals("")) {
			throw new MensagemErroGenerica("O campo telefone deve ser preenchido.");
		}
		if (novoContato.getTelefone().trim().length() < 8) {
			throw new MensagemErroGenerica("O campo telefone deve ter pelo menos oito dígitos.");
		}
		return true;
	}
}
