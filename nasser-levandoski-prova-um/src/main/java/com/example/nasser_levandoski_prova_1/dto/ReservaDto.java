package com.example.nasser_levandoski_prova_1.dto;

import java.time.LocalDate;

import com.example.nasser_levandoski_prova_1.entity.ReservaEntity;
import com.example.nasser_levandoski_prova_1.enums.StatusReservaEnum;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReservaDto {

	private Long id;

	@Nonnull
	private LocalDate dataReserva;
	private Integer numeroPessoas;
	private Integer numeroMesa;
	private StatusReservaEnum statusReservaEnum;
	private Long clienteId;

	public ReservaDto(ReservaEntity reservaEntity) {
		this.id = reservaEntity.getId();
		this.dataReserva = reservaEntity.getDataReserva();
		this.numeroPessoas = reservaEntity.getNumeroPessoas();
		this.numeroMesa = reservaEntity.getNumeroMesa();
		this.statusReservaEnum = reservaEntity.getStatusReservaEnum();
		this.clienteId = reservaEntity.getCliente().getId();
	}

}
