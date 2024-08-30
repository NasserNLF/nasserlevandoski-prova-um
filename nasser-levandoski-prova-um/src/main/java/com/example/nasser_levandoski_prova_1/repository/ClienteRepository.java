package com.example.nasser_levandoski_prova_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nasser_levandoski_prova_1.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

	
}
