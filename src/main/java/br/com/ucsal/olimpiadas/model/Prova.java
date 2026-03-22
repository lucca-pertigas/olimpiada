package br.com.ucsal.olimpiadas.model;

public class Prova {

	private long id;
	private String titulo;

	public Prova(String titulo) {
		setTitulo(titulo);	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if (titulo == null || titulo.isBlank()) {
			throw new IllegalArgumentException("Titulo da prova é obrigatorio");
		}
		this.titulo = titulo.trim();
	}
	@Override
	public String toString() {
		return id + " - " + titulo;
	}

}
