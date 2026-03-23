package br.com.ucsal.olimpiadas.command;

import java.util.List;
import java.util.Scanner;

import br.com.ucsal.olimpiadas.model.Prova;

import br.com.ucsal.olimpiadas.service.ProvaService;
import br.com.ucsal.olimpiadas.service.QuestaoService;

public class CadastrarQuestaoCommand implements Command{
	
	private final Scanner in;
	private final QuestaoService questaoService;
	private final ProvaService provaService;
	
	public CadastrarQuestaoCommand(Scanner in, QuestaoService questaoService, ProvaService provaService) {
		this.in = in;
		this.questaoService = questaoService;
		this.provaService = provaService;
	}
	
	@Override
	public void executar() {
		
		List<Prova> provas = provaService.listar();
		
		if(provas.isEmpty()) {
			System.out.println("Nenhuma prova cadastrada");
		}
		
		System.out.println("Provas disponiveis: ");
		for (Prova p : provas) {
			System.out.println(p.getId() + " - " + p.getTitulo());
		}
		
		System.out.println("Escolha o ID da prova: ");
		Long provaId;
		
		try {
			provaId = Long.parseLong(in.nextLine());
		} catch (Exception e) {
			System.out.println("ID invalido");
			return;
		}
		
		System.out.println("Enunciado: ");
		String enunciado = in.nextLine();
		
		String[] alternativas = new String[5];
		
		for (int i = 0; i < 5; i++) {
			char letra = (char) ('A' + i);
			System.out.println("Alternativa " + letra + ": ");
			alternativas[i] = letra + ") " + in.nextLine();
		}
		
		System.out.println("Alternativa correta (A-E): ");
		String correta = in.nextLine();
		
		try {
			var questao = questaoService.cadastrar(provaId, enunciado, alternativas, correta);
			
			System.out.println("Questao cadastrada: " + questao.getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
