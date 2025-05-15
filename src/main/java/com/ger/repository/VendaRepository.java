package com.ger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ger.entities.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}