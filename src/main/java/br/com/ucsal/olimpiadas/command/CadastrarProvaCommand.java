package br.com.ucsal.olimpiadas.command;

import java.util.Scanner;

import br.com.ucsal.olimpiadas.service.ProvaService;

public class CadastrarProvaCommand implements Command{
	
	private final Scanner in;
	private final ProvaService provaService;
	
	public CadastrarProvaCommand(Scanner in, ProvaService provaService) {
		this.in = in;
		this.provaService = provaService;
	}
	
	@Override
	public void executar() {
		System.out.print("Título da prova: ");
		String titulo = in.nextLine();
		
		try {
			var prova = provaService.cadastrar(titulo);
			System.out.println("Prova cadastrada: " + prova.getId());
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
}