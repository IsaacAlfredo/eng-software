package application;

public class Aluno extends Usuario{;

    public Aluno(String nome, String login, String senha){
    	super(nome, login, senha);

    }

	@Override
	public void prefixo() {
		this.setMatricula("AL");
		
	}
	
	public String listarDisciplinas() {
		String lista = "";
		for(Disciplina disciplina : this.getDisciplinas()) {
			int indexDisciplina = this.getDisciplinas().indexOf(disciplina)+1;
			lista += indexDisciplina +"- "+ disciplina.getNome()+"\n";
		}
		System.out.println("Suas disciplinas:\n"+lista+"\n===============================================================");
		return lista;
	}

}
