package com.ger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ger.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
