package com.example.nasser_levandoski_prova_1.service.impl;

import java.util.List;
import java.util.Optional;

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

	// 1 - POST Cliente
	@Override
	public ClienteDto postCliente(ClienteDto clienteDto) {

		var clienteEntity = new ClienteEntity(clienteDto);

		clienteRepository.save(clienteEntity);

		return new ClienteDto(clienteEntity);
	}

	// 2 - PUT Cliente
	@Override
	public ClienteDto putCliente(Long id, ClienteDto clienteDto) {

		var clienteEntityOptional = clienteRepository.findById(id);

		if (clienteEntityOptional.isPresent()) {
			var clienteEntity = clienteEntityOptional.get();

			clienteEntity.putRegistro(clienteDto);

			clienteRepository.save(clienteEntity);

			return new ClienteDto(clienteEntity);
		}

		return null;
	}
	
	// 3 - GET Cliente
	@Override
	public Optional<ClienteEntity> getCliente(Long id){
		return clienteRepository.findById(id);
	}

	//Apenas para testes
	@Override
	public List<ClienteDto> getAllClientes() {
		return clienteRepository.findAll().stream().map(ClienteDto::new).toList();
	}


	
	

}
