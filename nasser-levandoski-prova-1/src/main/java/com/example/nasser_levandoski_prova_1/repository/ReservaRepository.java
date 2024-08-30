package com.example.nasser_levandoski_prova_1.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nasser_levandoski_prova_1.entity.ReservaEntity;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {
	List<ReservaEntity> findAllByDataReserva(LocalDate dataReserva);
}
