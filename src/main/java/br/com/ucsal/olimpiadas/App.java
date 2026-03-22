package br.com.ucsal.olimpiadas;

import java.util.Scanner;

import br.com.ucsal.olimpiadas.command.CadastrarParticipanteCommand;
import br.com.ucsal.olimpiadas.command.SairCommand;
import br.com.ucsal.olimpiadas.service.ParticipanteService;

public class App {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		ParticipanteService participanteService = new ParticipanteService();
		
		var cadastrarParticipante = new CadastrarParticipanteCommand(in, participanteService);
		var sair = new SairCommand();
		
		Menu menu = new Menu(in);
		
		menu.registrar("1", cadastrarParticipante);
		menu.registrar("0", sair);
		
		menu.iniciar();
	}
}