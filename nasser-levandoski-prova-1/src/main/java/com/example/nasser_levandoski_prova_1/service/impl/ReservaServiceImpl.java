package com.example.nasser_levandoski_prova_1.service.impl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.nasser_levandoski_prova_1.dto.ReservaDto;
import com.example.nasser_levandoski_prova_1.entity.ReservaEntity;
import com.example.nasser_levandoski_prova_1.enums.StatusReservaEnum;
import com.example.nasser_levandoski_prova_1.repository.ReservaRepository;
import com.example.nasser_levandoski_prova_1.service.ClienteService;
import com.example.nasser_levandoski_prova_1.service.ReservaService;

@Primary
@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	ReservaRepository reservaRepository;

	@Autowired
	ClienteService clienteService;

	@Override
	public ReservaDto postReserva(ReservaDto reservaDto) {

		var clienteEntity = clienteService.getCliente(reservaDto.getClienteId());

		if (clienteEntity.isPresent() && reservaDto.getDataReserva().isAfter(LocalDate.now())
				&& reservaDto.getNumeroPessoas() <= 10 && reservaDto.getNumeroPessoas() > 0
				&& reservaDto.getNumeroMesa() > 0 && reservaDto.getNumeroMesa() <= 20
				&& getDisponibilidadeMesa(reservaDto.getNumeroMesa(), reservaDto.getDataReserva())) {

			var reservaEntityPersisitida = reservaRepository.save(new ReservaEntity(reservaDto, clienteEntity.get()));

			return new ReservaDto(reservaEntityPersisitida);
		}

		return null;
	}

	@Override
	public Boolean getDisponibilidadeMesa(Integer numeroMesa, LocalDate dataReserva) {

		List<ReservaEntity> reservas = reservaRepository.findAllByDataReserva(dataReserva);

		if (reservas.stream().filter(r -> r.getNumeroMesa().equals(numeroMesa)).toList().isEmpty()) {
			return true;
		}

		return false;
	}

	@Override
	public ReservaDto putStatusReserva(Long idReserva, ReservaDto reservaDto) {

		var reservaEntityOptional = reservaRepository.findById(idReserva);

		if (reservaEntityOptional.isPresent()) {

			if (reservaDto.getStatusReservaEnum().equals(StatusReservaEnum.CANCELADA)) {
				if (!reservaEntityOptional.get().getDataReserva().isBefore(LocalDate.now())) {
					return null;
				}
			}

			var reservaEntity = reservaEntityOptional.get();

			reservaEntity.putStatus(reservaDto);

			reservaRepository.save(reservaEntity);

			return new ReservaDto(reservaEntity);
		}
		return null;
	}

	@Override
	public List<ReservaDto> getAllReservasCliente(Long id) {
		var clienteEntity = clienteService.getCliente(id);

		if (clienteEntity.isPresent()) {

			return clienteEntity.get().getReservas().stream().map(ReservaDto::new).toList();
		}

		return Collections.emptyList();
	}

}
