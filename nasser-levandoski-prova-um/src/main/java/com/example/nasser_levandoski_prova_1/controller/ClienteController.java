package com.example.nasser_levandoski_prova_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nasser_levandoski_prova_1.dto.ClienteDto;
import com.example.nasser_levandoski_prova_1.service.ClienteService;

@RestController
@RequestMapping("cliente-controller")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	/*
	 * 1 - POST cliente 2 - PUT cliente 3 - Listar todas as reservas de um cliente
	 */

	@PostMapping("cadastro-cliente")
	public ClienteDto postCliente(@RequestBody ClienteDto clienteDto) {
		return clienteService.postCliente(clienteDto);
	}

	@PutMapping("cadastro-cliente/{id}")
	public ClienteDto putCliente(@PathVariable Long id, @RequestBody ClienteDto clienteDto) {
		return clienteService.putCliente(id, clienteDto);
	}

	// Feito apenas para testes
	@GetMapping("clientes")
	public List<ClienteDto> getAllClientes() {
		return clienteService.getAllClientes();
	}

}
