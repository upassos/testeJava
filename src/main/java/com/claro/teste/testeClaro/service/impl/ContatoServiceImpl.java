package com.claro.teste.testeClaro.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.claro.teste.testeClaro.service.ContatoService;
import com.claro.teste.testeClaro.service.dto.ContatoDto;
import com.claro.teste.testeClaro.service.dto.EnderecoDto;
import com.claro.teste.testeClaro.service.mapper.ContatoMapper;
import com.claro.teste.testeClaro.service.validator.ContatoValidator;
import com.claro.teste.testeClaro.exception.MensagemErroGenerica;
import com.claro.teste.testeClaro.model.Contato;
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
	
	@Autowired
	private ContatoValidator contatoValidator;
	
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

	@Override
	public ContatoDto registraContato(ContatoDto novoContato) {
		EnderecoDto enderecoDto = new EnderecoDto();
		enderecoDto = null;
		enderecoDto = contatoValidator.validaCEP(novoContato.getCep());
		if (enderecoDto != null) {
			if (contatoValidator.validaCamposContato(novoContato)) {
				Date date = new Date();
				novoContato.setDataCadastro(date);
				return contatoMapper.toDto(contatoRepository.save(contatoMapper.toEntity(novoContato)));
			}
		}
		
		return null;
	}

	@Override
	public ContatoDto getContato(String email) {
		
		Contato contato = contatoRepository.findByEmail(email);
		
		if (contato != null) {
			return contatoMapper.toDto(contato);
		}else {
			return null;
		}
		
	}

	@Override
	public ContatoDto alteraContato(ContatoDto novoContato, String email) {

		EnderecoDto enderecoDto = new EnderecoDto();
		enderecoDto = null;
		enderecoDto = contatoValidator.validaCEP(novoContato.getCep());
		if (enderecoDto != null) {
			if (contatoRepository.findByEmail(email) != null) {
				if (contatoValidator.validaCamposAlteracaoContato(novoContato)) {
					ContatoDto alterContatoDto = new ContatoDto();
					alterContatoDto.setEmail(email);
					alterContatoDto.setCep(novoContato.getCep());
					alterContatoDto.setCidade(novoContato.getCidade());
					alterContatoDto.setDataCadastro(novoContato.getDataCadastro());
					alterContatoDto.setEndereco(novoContato.getEndereco());
					alterContatoDto.setNome(novoContato.getNome());
					alterContatoDto.setTelefone(novoContato.getTelefone());
					alterContatoDto.setUf(novoContato.getUf());
					System.out.println("AQUI Ó --> \n"+alterContatoDto);
					return contatoMapper.toDto(contatoRepository.save(contatoMapper.toEntity(alterContatoDto)));
				}	
			}
			
		}
		
		return null;

	}

	@Override
	public void deleteContato(String email) {
		Contato recContato = contatoRepository.findByEmail(email);
		if (recContato != null) {
			contatoRepository.delete(recContato);
		} else {
			throw new MensagemErroGenerica("Não existe contato com o e-mail informado.");
		}
		
	}
	
	

}
