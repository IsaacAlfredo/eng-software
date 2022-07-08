package exceptions;

public class AlunoMatriculadoException extends Exception {
	public AlunoMatriculadoException() {
		super("Você já está matriculado nessa disciplina!");
	}
}
