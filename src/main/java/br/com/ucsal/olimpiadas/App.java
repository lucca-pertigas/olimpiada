package br.com.ucsal.olimpiadas;

import java.util.Scanner;

import br.com.ucsal.olimpiadas.command.CadastrarParticipanteCommand;
import br.com.ucsal.olimpiadas.command.SairCommand;
import br.com.ucsal.olimpiadas.command.CadastrarProvaCommand;

import br.com.ucsal.olimpiadas.service.ProvaService;
import br.com.ucsal.olimpiadas.service.ParticipanteService;

public class App {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		ParticipanteService participanteService = new ParticipanteService();
		ProvaService provaService = new ProvaService();
		
		var cadastrarParticipante = new CadastrarParticipanteCommand(in, participanteService);
		var sair = new SairCommand();
		var cadastrarProva = new CadastrarProvaCommand(in, provaService);
		
		Menu menu = new Menu(in);
		
		menu.registrar("1", cadastrarParticipante);
		menu.registrar("2", cadastrarProva);
		menu.registrar("0", sair);
		
		menu.iniciar();
	}
}