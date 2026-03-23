package br.com.ucsal.olimpiadas.service;

import java.util.ArrayList;
import java.util.List;

import br.com.ucsal.olimpiadas.model.Questao;

public class QuestaoService {
	
	private final List<Questao> questoes = new ArrayList<>();
	private long proximoId = 1;
	
	public Questao cadastrar(Long provaId, String enunciado, String[] alternativas, String entradaCorreta) {
		
		char correta;
		
		try {
			correta = Questao.normalizar(entradaCorreta.trim().charAt(0));
		} catch (Exception e) {
			throw new IllegalArgumentException("Alternativa correta invalida");
		}
		
		Questao q = new Questao();
		q.setProvaId(provaId);
		q.setEnunciado(enunciado);
		q.setAlternativas(alternativas);
		q.setAlternativaCorreta(correta);
		
		q.setId(proximoId++);
		
		questoes.add(q);
		
		return q;
	}
}
