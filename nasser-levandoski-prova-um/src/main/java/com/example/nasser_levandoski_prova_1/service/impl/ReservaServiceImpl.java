package com.example.nasser_levandoski_prova_1.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.nasser_levandoski_prova_1.dto.ReservaDto;
import com.example.nasser_levandoski_prova_1.entity.ClienteEntity;
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

		validaData(reservaDto.getDataReserva());
		validaNumPessoas(reservaDto.getNumeroPessoas());
		validaNumMesa(reservaDto.getNumeroMesa());
		validaDisponibilidadeMesa(reservaDto.getNumeroMesa(), reservaDto.getDataReserva());

		var clienteEntity = buscaCliente(reservaDto.getClienteId());

		var reservaEntityPersisitida = reservaRepository.save(new ReservaEntity(reservaDto, clienteEntity));

		return new ReservaDto(reservaEntityPersisitida);

	}

	@Override
	public ReservaDto putStatusReserva(Long idReserva, ReservaDto reservaDto) {

		var reservaEntity = validaReserva(idReserva);

		validaStatusReserva(reservaDto.getStatusReservaEnum(), reservaEntity.getDataReserva());

		reservaEntity.putStatus(reservaDto);

		return new ReservaDto(reservaRepository.save(reservaEntity));
	}

	@Override
	public List<ReservaDto> getAllReservasCliente(Long id) {
		return buscaCliente(id).getReservas().stream().map(ReservaDto::new).toList();
	}

	@Override
	public Boolean validaDisponibilidadeMesaBoolean(Integer numMesa, LocalDate dataReserva) {
		return !reservaRepository.existsByNumeroMesaAndDataReserva(numMesa, dataReserva);
	}

	/*
	 * Validações
	 */

	public void validaData(LocalDate data) {
		if (data.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("A data da reserva não pode ser feita para o passado");
		}
	}

	public void validaNumMesa(Integer numMesa) {
		if (numMesa < 1 || numMesa > 20) {
			throw new IllegalArgumentException("Os números de mesa vão de 1 a 20");
		}
	}

	public void validaNumPessoas(Integer qtdPessoas) {

		if (qtdPessoas < 1) {
			throw new IllegalArgumentException("A quantidade de pessoas não pode ser negativa");
		}

		if (qtdPessoas > 10) {
			throw new IllegalArgumentException("A quantidade máxima de pessoas em uma reserva é 10");
		}

	}

	public ClienteEntity buscaCliente(Long clienteId) {
		return clienteService.getCliente(clienteId);
	}

	public ReservaEntity validaReserva(Long idReserva) {

		var reservaEntity = reservaRepository.findById(idReserva);

		if (reservaEntity.isEmpty()) {
			throw new IllegalArgumentException("Essa reserva não existe!");
		}

		return reservaEntity.get();

	}

	public void validaStatusReserva(StatusReservaEnum status, LocalDate dataReserva) {
		if (status.equals(StatusReservaEnum.CANCELADA)) {
			if (dataReserva.equals(LocalDate.now()) || dataReserva.isBefore(LocalDate.now())) {
				throw new IllegalArgumentException("A reserva só pode ser cancelada com 1 dia de antecedência");
			}
		}
		
		if (status.equals(StatusReservaEnum.CONCLUIDA)) {
			if (dataReserva.isAfter(LocalDate.now())) {
				throw new IllegalArgumentException(
						"A data da reserva não pode ser concluída, pois ela ainda não ocorreu");
			}
		}

	}

	public void validaDisponibilidadeMesa(Integer numMesa, LocalDate dataReserva) {
		if (!validaDisponibilidadeMesaBoolean(numMesa, dataReserva)) {
			throw new IllegalArgumentException("Já há uma reserva nessa data para essa mesa");
		}
	};

}
