package java.dominio;

public class Serie {
	private String titulo;
	private String genero;
	private String temporadas;
	
	public Serie() {
	}
	
	public Serie(String titulo, String genero, String temporadas) {
		this.titulo = titulo;
		this.genero = genero;
		this.temporadas = temporadas;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getTemporadas() {
		return temporadas;
	}
	
	public void setTemporadas(String temporadas) {
		this.temporadas = temporadas;
	}
}