package application;

public class Aula {
	private String nome;
	private String link;
	
	public Aula(String nome, String link){
		this.setNome(nome);
		this.setLink(link);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}
