package com.jhonathan.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonathan.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
