package com.example.nasser_levandoski_prova_1.entity;

import java.util.List;

import com.example.nasser_levandoski_prova_1.dto.ClienteDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "cliente")
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String email;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<ReservaEntity> reservas;

	public ClienteEntity(ClienteDto clienteDto) {
		this.id = clienteDto.getId();
		this.nome = clienteDto.getNome();
		this.email = clienteDto.getEmail();
	}

	public ClienteEntity putRegistro(ClienteDto clienteDto) {
		this.nome = clienteDto.getNome();
		this.email = clienteDto.getEmail();

		return this;
	}

}
