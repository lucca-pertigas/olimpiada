package br.com.ucsal.olimpiadas.service;

import br.com.ucsal.olimpiadas.model.Prova;

public class ProvaService {
	private long proximoId = 1;
	
	public Prova cadastrar(String titulo) {
		
		Prova prova = new Prova(titulo);
		prova.setId(proximoId++);
		
		return prova;
	}
}
