package com.example.nasser_levandoski_prova_1.service;

import com.example.nasser_levandoski_prova_1.dto.ClienteDto;
import com.example.nasser_levandoski_prova_1.entity.ClienteEntity;

public interface ClienteService {
	ClienteDto postCliente(ClienteDto clienteDto);
	ClienteDto putCliente(Long id,ClienteDto clienteDto);
	ClienteEntity getCliente(Long id);
	

	
}
