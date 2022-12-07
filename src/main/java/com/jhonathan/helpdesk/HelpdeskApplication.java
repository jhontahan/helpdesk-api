package com.jhonathan.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jhonathan.helpdesk.domain.Chamado;
import com.jhonathan.helpdesk.domain.Cliente;
import com.jhonathan.helpdesk.domain.Tecnico;
import com.jhonathan.helpdesk.domain.enuns.Perfil;
import com.jhonathan.helpdesk.domain.enuns.Prioridade;
import com.jhonathan.helpdesk.domain.enuns.Status;
import com.jhonathan.helpdesk.repositories.ChamadoRepository;
import com.jhonathan.helpdesk.repositories.ClienteRepository;
import com.jhonathan.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner{
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico(null, "jhonathan", "834.191.560-06", 
				     "jhonathan@gmail.com", "123");
		
		tec1.addPerfil(Perfil.ADMIN);
		
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "271.797.240-41", 
				     "torvalds@email.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO,
						"Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));

		clienteRepository.saveAll(Arrays.asList(cli1));

		chamadoRepository.saveAll(Arrays.asList(c1));
		
		
	}

}
