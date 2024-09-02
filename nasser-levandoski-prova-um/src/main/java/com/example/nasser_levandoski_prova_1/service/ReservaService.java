package com.example.nasser_levandoski_prova_1.service;

import java.time.LocalDate;
import java.util.List;

import com.example.nasser_levandoski_prova_1.dto.ReservaDto;

public interface ReservaService {
	ReservaDto postReserva(ReservaDto reservaDto);
	ReservaDto putStatusReserva(Long idReserva, ReservaDto reservaDto);
	List<ReservaDto> getAllReservasCliente(Long id);
	Boolean validaDisponibilidadeMesaBoolean(Integer numMesa, LocalDate dataReserva);
	

	
	
}
