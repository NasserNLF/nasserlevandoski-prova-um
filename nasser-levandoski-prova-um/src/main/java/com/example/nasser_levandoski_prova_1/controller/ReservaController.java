package com.example.nasser_levandoski_prova_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nasser_levandoski_prova_1.dto.ReservaDto;
import com.example.nasser_levandoski_prova_1.service.ReservaService;

@RestController
@RequestMapping("reserva-controller")
public class ReservaController {

	@Autowired
	ReservaService reservaService;


	@PostMapping("cadastro-reserva")
	public ResponseEntity<?> postReserva(@RequestBody ReservaDto reservaDto) {
		try {
			return ResponseEntity.ok(reservaService.postReserva(reservaDto));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	// Voltar depois
	@GetMapping("reservas-cliente/{id}")
	public ResponseEntity<?> getAllreservaCliente(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(reservaService.getAllReservasCliente(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("disponibilidade-mesa")
	public ResponseEntity<?> getDisponibilidade(@RequestBody ReservaDto reservaDto) {
		try {
			return ResponseEntity.ok(
					reservaService.validaDisponibilidadeMesaBoolean(reservaDto.getNumeroMesa(), reservaDto.getDataReserva()));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@PutMapping("troca-status/{id}")
	public ResponseEntity<?> putStatus(@PathVariable Long id, @RequestBody ReservaDto reservaDto) {
		try {
			return ResponseEntity.ok(reservaService.putStatusReserva(id, reservaDto));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

}
