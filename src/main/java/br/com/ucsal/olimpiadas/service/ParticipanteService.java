package br.com.ucsal.olimpiadas.service;

import java.util.ArrayList;
import java.util.List;

import br.com.ucsal.olimpiadas.model.Participante;

public class ParticipanteService {
	
	private final List<Participante> participantes = new ArrayList<>();
	private long proximoId = 1;
	
	public Participante cadastrar(String nome, String email) {
		
		if (nome == null || nome.isBlank()) {
	        throw new IllegalArgumentException("nome inválido");
	    }
		
		Participante p = new Participante(null, nome, email);
		p.setId(proximoId++);
		
		participantes.add(p);
		
		return p;
	}
}
