package com.example.nasser_levandoski_prova_1.entity;

import java.time.LocalDate;

import com.example.nasser_levandoski_prova_1.dto.ReservaDto;
import com.example.nasser_levandoski_prova_1.enums.StatusReservaEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "reserva")
public class ReservaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private LocalDate dataReserva;
	
	@Column(nullable = false)
	private Integer numeroPessoas;
	
	@Column(nullable = false)
	private Integer numeroMesa;

	@Enumerated(EnumType.ORDINAL)
	private StatusReservaEnum statusReservaEnum;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "cliente_id", nullable = false)
	private ClienteEntity cliente;

	public ReservaEntity(ReservaDto reservaDto, ClienteEntity clienteEntity) {
		this.id = reservaDto.getClienteId();
		this.dataReserva = reservaDto.getDataReserva();
		this.numeroPessoas = reservaDto.getNumeroPessoas();
		this.numeroMesa = reservaDto.getNumeroMesa();
		this.statusReservaEnum = (reservaDto.getStatusReservaEnum() == null) ? StatusReservaEnum.FEITA : reservaDto.getStatusReservaEnum();
		this.cliente = clienteEntity;
	}

	public ReservaEntity putStatus(ReservaDto reservaDto) {
		this.statusReservaEnum = reservaDto.getStatusReservaEnum();

		return this;
	}

}
