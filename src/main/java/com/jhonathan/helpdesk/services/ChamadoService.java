package com.jhonathan.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonathan.helpdesk.domain.Chamado;
import com.jhonathan.helpdesk.domain.Cliente;
import com.jhonathan.helpdesk.domain.Tecnico;
import com.jhonathan.helpdesk.domain.dtos.ChamadoDTO;
import com.jhonathan.helpdesk.domain.enuns.Prioridade;
import com.jhonathan.helpdesk.domain.enuns.Status;
import com.jhonathan.helpdesk.repositories.ChamadoRepository;
import com.jhonathan.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {
	
	@Autowired
	private ChamadoRepository repository;
	@Autowired
	private TecnicoService tecnicoService;
	@Autowired
	private ClienteService clienteService;
	
	
	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return  obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: Id " + id));
	}

	public List<Chamado> findAll() {
		return repository.findAll();
	}

	public Chamado create(@Valid ChamadoDTO dto) {
		return repository.save(newChamado(dto));
	}
	
	private Chamado newChamado(ChamadoDTO dto) {
		Tecnico tecnico = tecnicoService.findById(dto.getTecnico());
		Cliente cliente = clienteService.findById(dto.getCliente());
		
		Chamado chamado = new Chamado();
		if(dto.getId() != null) {
			chamado.setId(dto.getId());
		}
		chamado.setTecnico(tecnico);
		chamado.setCliente(cliente);
		chamado.setPrioridade(Prioridade.toEnum(dto.getPrioridade()));
		chamado.setStatus(Status.toEnum(dto.getStatus()));
		chamado.setTitulo(dto.getTitulo());
		chamado.setObservacoes(dto.getObservacoes());
		
		return chamado;
		
	}
}
