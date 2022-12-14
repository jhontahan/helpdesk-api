package com.jhonathan.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jhonathan.helpdesk.domain.Chamado;
import com.jhonathan.helpdesk.domain.Cliente;
import com.jhonathan.helpdesk.domain.Tecnico;
import com.jhonathan.helpdesk.domain.enuns.Perfil;
import com.jhonathan.helpdesk.domain.enuns.Prioridade;
import com.jhonathan.helpdesk.domain.enuns.Status;
import com.jhonathan.helpdesk.repositories.ChamadoRepository;
import com.jhonathan.helpdesk.repositories.ClienteRepository;
import com.jhonathan.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "jhonathan", "834.191.560-06", 
			     "jhonathan@gmail.com", encoder.encode("123"));
		
		Tecnico tec2 = new Tecnico(null, "Weverton", "841.479.960-43", 
			     "weverton@gmail.com", encoder.encode("123"));
	
	tec1.addPerfil(Perfil.ADMIN);
	
	
	Cliente cli1 = new Cliente(null, "Linus Torvalds", "271.797.240-41", 
			     "torvalds@email.com", encoder.encode("123"));
	
	Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO,
					"Chamado 01", "Primeiro chamado", tec1, cli1);
	
	tecnicoRepository.saveAll(Arrays.asList(tec1, tec2));

	clienteRepository.saveAll(Arrays.asList(cli1));

	chamadoRepository.saveAll(Arrays.asList(c1));
	}
	
}
