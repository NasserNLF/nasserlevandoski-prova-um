package com.example.nasser_levandoski_prova_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	@PostMapping("cadastro-cliente")
	public ResponseEntity<?> postCliente(@RequestBody ClienteDto clienteDto) {
		try {
			return ResponseEntity.ok(clienteService.postCliente(clienteDto));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("cadastro-cliente/{id}")
	public ResponseEntity<?> putCliente(@PathVariable Long id, @RequestBody ClienteDto clienteDto) {
		try {
			return ResponseEntity.ok(clienteService.putCliente(id, clienteDto));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
