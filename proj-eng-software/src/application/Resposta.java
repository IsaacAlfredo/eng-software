package application;

public class Resposta {
	private Aluno aluno;
	private String link;
	private float nota;
	
	public Resposta(Aluno aluno, String link) {
		this.setAluno(aluno);
		this.setLink(link);
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
}
