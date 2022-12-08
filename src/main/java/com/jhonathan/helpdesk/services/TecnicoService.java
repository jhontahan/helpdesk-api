package com.jhonathan.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonathan.helpdesk.domain.Tecnico;
import com.jhonathan.helpdesk.repositories.TecnicoRepository;
import com.jhonathan.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		
		Optional<Tecnico> tecnico = repository.findById(id);
		
		return tecnico.orElseThrow(() -> 
					new ObjectNotFoundException("Técnico: " + id + " não encontrado!"));
		
//		if(!tecnico.isPresent()) {
//			return null;
//		}
//		
//		return tecnico.get();
	}
	
}
