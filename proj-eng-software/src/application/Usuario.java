package application;

import java.util.ArrayList;


public abstract class Usuario{
	private String nome;
	private String matricula;
	private String login;
	private String senha;
    private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();

	
	public Usuario(String nome,String login, String senha){
		this.setNome(nome);
		this.setLogin(login);
		this.setSenha(senha);
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void gerarMatriculaTemplateMethod(int tamanho, int ano) {
		this.prefixo();
		this.numSufixo(tamanho);
		this.anoSufixo(ano);
		this.matriculaToString();
		
	}
	
	public abstract void prefixo();
	
	public void numSufixo(int tamanho) {
		this.setMatricula(this.getMatricula() + Integer.toString(tamanho));
	}
	
	public void anoSufixo(int ano) {
		String anoString = Integer.toString(ano);
		this.setMatricula(this.getMatricula() + anoString.charAt(2) + anoString.charAt(3));
	}
	
	public void matriculaToString() {
		System.out.println("Matricula gerada com sucesso!\n Sua matricula: "+ this.getMatricula()+"\n===============================================================");
	}
	
	public abstract String listarDisciplinas();

}