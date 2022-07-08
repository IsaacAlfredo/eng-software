package exceptions;

public class UsuarioInexistenteException extends Exception {
	public UsuarioInexistenteException() {
		super("Usuario inexistente!");
	}
}
