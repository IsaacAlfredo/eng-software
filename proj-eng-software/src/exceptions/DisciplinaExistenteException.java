package exceptions;

public class DisciplinaExistenteException extends Exception {
	public DisciplinaExistenteException() {
		super("Esta disciplina já existe em sua lista!");
	}
}
