package application;

import java.util.ArrayList;

public class Atividade {
	private String link;
	private ArrayList<Resposta> respostas = new ArrayList<Resposta>();
	
	public Atividade(String link) {
		this.setLink(link);
	}
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public ArrayList<Resposta> getRespostas() {
		return respostas;
	}
	public void setRespostas(ArrayList<Resposta> respostas) {
		this.respostas = respostas;
	}
}
