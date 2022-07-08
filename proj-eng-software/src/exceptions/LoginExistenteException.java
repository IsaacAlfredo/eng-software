package exceptions;

public class LoginExistenteException extends Exception {
	public LoginExistenteException() {
		super("Login ja existente, tente novamente!");
	}
}
