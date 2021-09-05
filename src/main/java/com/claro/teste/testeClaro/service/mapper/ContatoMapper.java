package com.claro.teste.testeClaro.service.mapper;

import org.mapstruct.Mapper;

import com.claro.teste.testeClaro.model.Contato;
import com.claro.teste.testeClaro.service.dto.ContatoDto;

@Mapper(componentModel="spring")
public interface ContatoMapper extends EntityMapper<ContatoDto, Contato> {

}
