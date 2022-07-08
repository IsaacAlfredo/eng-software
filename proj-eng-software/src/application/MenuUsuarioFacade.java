package application;

import java.util.Scanner;

import exceptions.AlunoMatriculadoException;
import exceptions.DisciplinaExistenteException;
import exceptions.EntradaInvalidaException;
import exceptions.LimiteDisciplinaException;

public class MenuUsuarioFacade {
	private Professor professor;
	private Aluno aluno;
	private Scanner scFuncionalidade = new Scanner(System.in);
	private boolean matriculaFlag = true;


	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(String professorLogin, BancoDeDados bd) {
		for (Professor professor : bd.getProfessores()) {
			if(professor.getLogin().equals(professorLogin)) {
				this.professor = professor;
				break;
			}
		}
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(String alunoLogin, BancoDeDados bd) {
		for (Aluno aluno : bd.getAlunos()) {
			if(aluno.getLogin().equals(alunoLogin)) {
				this.aluno = aluno;
				break;
			}
		}
	}

	public Scanner getScFuncionalidade() {
		return scFuncionalidade;
	}

	public boolean getMatriculaFlag() {
		return matriculaFlag;
	}

	public void setMatriculaFlag(boolean matriculaFlag) {
		this.matriculaFlag = matriculaFlag;
	}

	public MenuUsuarioFacade(){}
	
	
	public void MenuProfessor(BancoDeDados bd, String professorLogin) throws EntradaInvalidaException{
		Scanner scCriarDisciplina = new Scanner(System.in);
		this.setProfessor(professorLogin, bd);
		
		System.out.println("Login realizado com sucesso como Professor\n===============================================================");

		
		boolean funcionalidadeFlag = true;
		
		while (funcionalidadeFlag == true) {
			System.out.println("0- Sair\n1- Listar disciplinas\n2- Criar nova disciplina\n===============================================================");
			String funcionalidade = this.getScFuncionalidade().nextLine();
			
			switch(funcionalidade) {
			case "0":
				funcionalidadeFlag = false;
				break;
			case "1":
				this.getProfessor().listarDisciplinas();
				break;
			case "2":
				System.out.println("Nome da disciplina: ");
				String nomeDisciplina = scCriarDisciplina.nextLine();
				System.out.println("Ementa da disciplina: ");
				String ementaDisciplina = scCriarDisciplina.nextLine();
				Disciplina disciplina = new Disciplina(nomeDisciplina,this.professor.getNome(),ementaDisciplina);
				this.criarDisciplina(disciplina, bd);	
				break;
			case "3":
				break;
			default:
				throw new EntradaInvalidaException();
			}
		}
	}
	public void criarDisciplina(Disciplina disciplina, BancoDeDados bd) {
		try {
			if(this.getProfessor().disciplinaExistente(disciplina) == false) {
				try {
					this.getProfessor().adicionarDisciplina(disciplina, bd);
				} catch (LimiteDisciplinaException lde) {
					System.out.println(lde.getMessage()+"\n==============================================================="); 
				}
			}
		} catch (DisciplinaExistenteException dee) {
			System.out.println(dee.getMessage()+"\n==============================================================="); 
		}
	}
	
	public void MenuAluno(BancoDeDados bd, String alunoLogin) throws EntradaInvalidaException{
		Scanner scMatricula = new Scanner(System.in);
		this.setAluno(alunoLogin, bd);
		boolean funcionalidadeFlag = true;
		
		while (funcionalidadeFlag == true) {
			System.out.println("0- Sair\n1- Disciplinas matriculadas\n2- Matricular-se em disciplina\n===============================================================");
			String funcionalidade = this.getScFuncionalidade().nextLine();
			
			switch(funcionalidade) {
			case "0":
				funcionalidadeFlag = false;
				break;
			case "1":
				this.getAluno().listarDisciplinas();
				break;
			case "2":
				this.setMatriculaFlag(true);
				
				while(this.getMatriculaFlag() == true) {
					System.out.println("Selecione as disciplinas que deseja matricular-se:\n0- Sair\n===============================================================");
					for (Disciplina disciplina : bd.getDisciplinas()) {
						int indexDisciplina = bd.getDisciplinas().indexOf(disciplina)+1;
						System.out.println(indexDisciplina +"- "+ disciplina.getNome() + ", professor: "+disciplina.getProfessor()+", ementa: "+disciplina.getEmenta());
					}
					String matricula = scMatricula.nextLine();
					try {
						this.MatricularAluno(matricula, bd);
					} catch (AlunoMatriculadoException ame) {
						System.out.println(ame.getMessage()+"\n===============================================================");
					}
				}
				break;
				default:
					throw new EntradaInvalidaException();
			}
		}
	}
	public void MatricularAluno(String matricula, BancoDeDados bd) throws AlunoMatriculadoException {
		try{	
		int matriculaInt = Integer.parseInt(matricula);
		if(matriculaInt == 0) {
			this.setMatriculaFlag(false);
		}else {
			for(Disciplina disciplina : bd.getDisciplinas()) {
				if (bd.getDisciplinas().indexOf(disciplina)==matriculaInt-1) {
					if (this.getAluno().getDisciplinas().contains(disciplina)){
						throw new AlunoMatriculadoException();
					}else {
						aluno.getDisciplinas().add(disciplina);
						System.out.println("A matricula na disciplina "+ disciplina.getNome() +" foi realizada com sucesso.\n===============================================================");
					}
				break;
				}
			}
		}
		} catch(NumberFormatException nfe) {
			System.out.println(nfe.getMessage()+"\n===============================================================");
		}		
	}
}
