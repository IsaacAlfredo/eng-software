package application;

import java.util.ArrayList;

public class Disciplina {
	private String nome;
	private String professor;
	private String ementa;
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private ArrayList<Aula> aulas = new ArrayList<Aula>();
	private ArrayList<Atividade> atividades = new ArrayList<Atividade>();
	
	public Disciplina(String nome, String professor, String ementa){
		this.setNome(nome);
		this.setProfessor(professor);
		this.setEmenta(ementa);
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getEmenta() {
		return ementa;
	}
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	public ArrayList<Atividade> getAtividades() {
		return atividades;
	}
	public void setAtividades(ArrayList<Atividade> atividades) {
		this.atividades = atividades;
	}
	public ArrayList<Aula> getAulas() {
		return aulas;
	}
	public void setAulas(ArrayList<Aula> aulas) {
		this.aulas = aulas;
	}
}
