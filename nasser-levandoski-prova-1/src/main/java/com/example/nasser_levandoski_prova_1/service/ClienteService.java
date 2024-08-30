package com.example.nasser_levandoski_prova_1.service;

import java.util.List;
import java.util.Optional;

import com.example.nasser_levandoski_prova_1.dto.ClienteDto;
import com.example.nasser_levandoski_prova_1.entity.ClienteEntity;

public interface ClienteService {
	ClienteDto postCliente(ClienteDto clienteDto);
	ClienteDto putCliente(Long id,ClienteDto clienteDto);
	Optional<ClienteEntity> getCliente(Long id);
	
	//Apenas para testes
	List<ClienteDto> getAllClientes();
	
}
