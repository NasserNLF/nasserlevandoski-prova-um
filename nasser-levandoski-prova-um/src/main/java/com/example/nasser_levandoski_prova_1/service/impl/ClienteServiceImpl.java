package com.example.nasser_levandoski_prova_1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.nasser_levandoski_prova_1.dto.ClienteDto;
import com.example.nasser_levandoski_prova_1.entity.ClienteEntity;
import com.example.nasser_levandoski_prova_1.repository.ClienteRepository;
import com.example.nasser_levandoski_prova_1.service.ClienteService;

@Primary
@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	// Cadastro Cliente
	@Override
	public ClienteDto postCliente(ClienteDto clienteDto) {

		var clienteEntity = new ClienteEntity(clienteDto);

		return new ClienteDto(clienteRepository.save(clienteEntity));
	}

	// Alterando status Cliente
	@Override
	public ClienteDto putCliente(Long id, ClienteDto clienteDto) {

		var clienteEntity = getCliente(id);

		clienteEntity.putRegistro(clienteDto);

		return new ClienteDto(clienteRepository.save(clienteEntity));

	}

	// Buscando cliente no banco
	@Override
	public ClienteEntity getCliente(Long id) {

		var clienteEntity = clienteRepository.findById(id);

		if (clienteEntity.isEmpty()) {
			throw new IllegalArgumentException("Cliente inexistente!");
		}

		return clienteEntity.get();
	}


}
