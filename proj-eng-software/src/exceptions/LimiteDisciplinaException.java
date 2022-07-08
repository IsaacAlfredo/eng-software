package exceptions;

public class LimiteDisciplinaException extends Exception {
	public LimiteDisciplinaException() {
		super("A quantidade limite de disciplinas foi alcançada!");
	}
}
