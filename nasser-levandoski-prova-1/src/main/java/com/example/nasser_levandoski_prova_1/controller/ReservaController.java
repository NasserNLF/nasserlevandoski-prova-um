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

import com.example.nasser_levandoski_prova_1.dto.ReservaDto;
import com.example.nasser_levandoski_prova_1.service.ReservaService;

@RestController
@RequestMapping("reserva-controller")
public class ReservaController {

	@Autowired
	ReservaService reservaService;

	/*
	 * 
	 * 1 - POST RESERVA 2 - GET ALL RESERVA POR CLIENTE 3 - GET DISPONIBILIDADE DE
	 * UMA MESA ESPECIFICA 4 - PUT STATUS RESERVA
	 */

	@PostMapping("cadastro-reserva")
	public ReservaDto postReserva(@RequestBody ReservaDto reservaDto) {
		return reservaService.postReserva(reservaDto);
	}

	// Voltar depois
	@GetMapping("reservas-cliente/{id}")
	public List<ReservaDto> getAllreservaCliente(@PathVariable Long id) {
		return reservaService.getAllReservasCliente(id);
	}

	@GetMapping("disponibilidade-mesa")
	public Boolean getDisponibilidade(@RequestBody ReservaDto reservaDto) {
		return reservaService.getDisponibilidadeMesa(reservaDto.getNumeroMesa(), reservaDto.getDataReserva());
	}

	//
	@PutMapping("troca-status/{id}")
	public ReservaDto putStatus(@PathVariable Long id, @RequestBody ReservaDto reservaDto) {
		return reservaService.putStatusReserva(id, reservaDto);
	}

}
