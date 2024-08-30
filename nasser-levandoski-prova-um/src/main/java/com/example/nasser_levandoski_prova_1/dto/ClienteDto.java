package com.example.nasser_levandoski_prova_1.dto;

import com.example.nasser_levandoski_prova_1.entity.ClienteEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ClienteDto {

	private Long id;

	private String nome;
	private String email;

	public ClienteDto(ClienteEntity clienteEntity) {
		this.id = clienteEntity.getId();
		this.nome = clienteEntity.getNome();
		this.email = clienteEntity.getEmail();
	}

}
