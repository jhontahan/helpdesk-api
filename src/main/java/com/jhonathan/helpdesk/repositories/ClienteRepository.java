package com.jhonathan.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonathan.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
