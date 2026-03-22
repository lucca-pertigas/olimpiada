package br.com.ucsal.olimpiadas.command;

import java.util.Scanner;

import br.com.ucsal.olimpiadas.service.ParticipanteService;

public class CadastrarParticipanteCommand implements Command{
	private final Scanner in;
	private final ParticipanteService participanteService;
	
	public CadastrarParticipanteCommand(Scanner in, ParticipanteService participanteService) {
		this.in = in;
		this.participanteService = participanteService;
	}
	
	@Override
	public void executar() {
		System.out.print("Nome: ");
		String nome = in.nextLine();
		
		System.out.print("Email (opcional): ");
		String email = in.nextLine();
		
		var participante = participanteService.cadastrar(nome, email);
		System.out.println("Participante cadastrado: " + participante.getId());
		
		
	}
}
