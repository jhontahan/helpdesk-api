package com.jhonathan.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonathan.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{

}
