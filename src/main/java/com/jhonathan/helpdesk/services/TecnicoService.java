package com.jhonathan.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonathan.helpdesk.domain.Pessoa;
import com.jhonathan.helpdesk.domain.Tecnico;
import com.jhonathan.helpdesk.domain.dtos.TecnicoDTO;
import com.jhonathan.helpdesk.repositories.PessoaRepository;
import com.jhonathan.helpdesk.repositories.TecnicoRepository;
import com.jhonathan.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.jhonathan.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Tecnico findById(Integer id) {
		
		Optional<Tecnico> tecnico = repository.findById(id);
		
		return tecnico.orElseThrow(() -> 
					new ObjectNotFoundException("Técnico: " + id + " não encontrado!"));
	}

	public List<Tecnico> findAll(Object object) {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfEEmail(objDTO);
		Tecnico obj = new Tecnico(objDTO);
		return repository.save(obj);
		
	}
	
	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
		objDTO.setId(id);
		Tecnico oldObj = findById(id);
		validaPorCpfEEmail(objDTO);
		oldObj = new Tecnico(objDTO);
		return repository.save(oldObj);
		
	}
	
	public void delete(Integer id) {
		Tecnico obj = findById(id);
		if(obj.getChamados().size() > 0) {
			throw new DataIntegrityViolationException("Técnico possui ordens de serviço e não pode ser deletado!");
		}
		repository.deleteById(id);
	}

	private void validaPorCpfEEmail(TecnicoDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
		}
	}

	

}
