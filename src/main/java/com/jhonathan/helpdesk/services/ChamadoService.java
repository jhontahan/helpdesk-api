package com.jhonathan.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonathan.helpdesk.domain.Chamado;
import com.jhonathan.helpdesk.repositories.ChamadoRepository;
import com.jhonathan.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {
	
	@Autowired
	private ChamadoRepository repository;
	
	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return  obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: Id " + id));
	}
}
