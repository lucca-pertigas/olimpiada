package br.com.ucsal.olimpiadas.model;

public class Participante {
	private Long id;
	private String nome;
	private String email;
	
	public Participante(Long id, String nome, String email) {
		this.id = id;
		setNome(nome);
		setEmail(email);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Nome do participante e obrigatorio");
		}
		this.nome = nome.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == null || email.isBlank()) {
			this.email = null;
			return;
		}
		
		if (!email.contains("@")) {
			throw new IllegalArgumentException("Email invalido");
		}
		
		this.email = email.trim();
		
	}
	
	public boolean temEmail() {
		return email != null;
	}
	
	@Override
	public String toString() {
		return id + " - " + nome + " - " + email;
	}
	
}
