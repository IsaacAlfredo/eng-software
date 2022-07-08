package application;

import exceptions.DisciplinaExistenteException;
import exceptions.LimiteDisciplinaException;

public class Professor extends Usuario{

    public Professor(String nome, String login, String senha){
    	super(nome, login, senha);

    }

	@Override
	public void prefixo() {
		this.setMatricula("PR");
		
	}
	
	public boolean disciplinaExistente(Disciplina novaDisciplina) throws DisciplinaExistenteException{
		for(Disciplina disciplina : this.getDisciplinas()) {
			if (disciplina.getNome().equals(novaDisciplina.getNome())){
				throw new DisciplinaExistenteException();
			}
		}
		return false;
	}
	
	public String listarDisciplinas() {
		String lista = "";
		for(Disciplina disciplina : this.getDisciplinas()) {
			lista += this.getDisciplinas().indexOf(disciplina)+1 +"- "+ disciplina.getNome()+"\n";
		}
		System.out.println("Suas disciplinas:\n"+lista+"\n===============================================================");
		return lista;
	}

	public void adicionarDisciplina(Disciplina disciplina, BancoDeDados bd) throws LimiteDisciplinaException{
		if(this.getDisciplinas().size() < 4) {
			this.getDisciplinas().add(disciplina);
			bd.getDisciplinas().add(disciplina);
			System.out.println("Disciplina criada com sucesso\n===============================================================");
		}else {
			throw new LimiteDisciplinaException();
		}
	}

}
