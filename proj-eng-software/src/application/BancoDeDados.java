package application;
import java.util.ArrayList;

import exceptions.LoginExistenteException;
import exceptions.SenhaInvalidaException;

public class BancoDeDados {
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public ArrayList<Professor> getProfessores() {
		return professores;
	}

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public void cadastrarAluno(Aluno novoAluno) throws LoginExistenteException{
		if(this.consultarLogin(novoAluno.getLogin()) == false) {
			getAlunos().add(novoAluno);
		}
		else {
			throw new LoginExistenteException();
		}
		
		
	}
	
	public boolean consultarAluno(Aluno aluno) {
		if(getAlunos().contains(aluno)) {
			return true;
		}
		else {
			return false;
		}

	}
	
	public ArrayList<String> recuperarMatriculasAlunos() {
		ArrayList<String> matriculasAlunos = new ArrayList<String>();
		for(Aluno aluno : getAlunos()) {
			matriculasAlunos.add(aluno.getMatricula());
		}
		return matriculasAlunos;
	}
	
	public void cadastrarProfessor(Professor novoProfessor) throws LoginExistenteException{
		if(this.consultarLogin(novoProfessor.getLogin())==false) {
			getProfessores().add(novoProfessor);
		}
		else {
			throw new LoginExistenteException();
		}
	}
	
	public boolean consultarProfessor(Professor professor) {
		if(getProfessores().contains(professor)) {
			return true;
		}
		else {
			return false;
		}
	}
	public ArrayList<String> recuperarMatriculasProfessores() {
		ArrayList<String> matriculasProfessores = new ArrayList<String>();
		for(Professor professor : getProfessores()) {
			matriculasProfessores.add(professor.getMatricula());
		}
		return matriculasProfessores;
	}
	public boolean consultarLogin(String login) {
		for (Professor professor : getProfessores()) {
			if(professor.getLogin().equals(login)) {
				return true;
			}
		}
		for (Aluno aluno : getAlunos()) {
			if(aluno.getLogin().equals(login)) {
				return true;
			}			
		}
		return false;
	}
	public boolean validarSenhaProfessor(String login,String senha) throws SenhaInvalidaException{
		for (Professor professor : getProfessores()) {
			if(professor.getLogin().equals(login)) {
				if(!professor.getSenha().equals(senha)) {
					throw new SenhaInvalidaException();
				}
			}
		}
		return true;
	}
	public boolean validarSenhaAluno(String login, String senha) throws SenhaInvalidaException{
		for (Aluno aluno : getAlunos()) {
			if(aluno.getLogin().equals(login)) {
				if(!aluno.getSenha().equals(senha)) {
					throw new SenhaInvalidaException();
				}
			}			
		}
		return true;
	}
	public void cadastrarDisciplina(Disciplina disciplina) {
		this.getDisciplinas().add(disciplina);
	}
}
