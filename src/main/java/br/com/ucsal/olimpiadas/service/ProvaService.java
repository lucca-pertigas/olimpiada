package br.com.ucsal.olimpiadas.service;

import java.util.ArrayList;
import java.util.List;

import br.com.ucsal.olimpiadas.model.Prova;

public class ProvaService {
	private final List<Prova> provas = new  ArrayList<>();
	private long proximoId = 1;
	
	public Prova cadastrar(String titulo) {
		
		Prova prova = new Prova(titulo);
		prova.setId(proximoId++);
		
		return prova;
	}
	
	public List<Prova> listar() {
		return provas;
	}
}
