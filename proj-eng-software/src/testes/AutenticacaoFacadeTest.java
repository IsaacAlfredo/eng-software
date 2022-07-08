package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import application.Aluno;
import application.AutenticacaoFacade;
import exceptions.EntradaInvalidaException;
import exceptions.UsuarioInexistenteException;

class AutenticacaoFacadeTest {
	private AutenticacaoFacade autenticacao = new AutenticacaoFacade();
	private Aluno joao = new Aluno("joao","joao123","joao10");

	@Test
	void testCadastroValidacao1() {
		try {
			autenticacao.CadastroValidacao("1", joao.getNome(), joao.getLogin(), joao.getSenha());
		} catch (EntradaInvalidaException e) {
			fail("Entrada invalida erroneamente encontrada");
			e.printStackTrace();
		}
	}
	
	@Test
	void testCadastroValidacao2() {
		try {
			autenticacao.CadastroValidacao("a", joao.getNome(), joao.getLogin(), joao.getSenha());
			fail("Entrada invalida indevidamente encontrada");
		} catch (EntradaInvalidaException e) {
			e.printStackTrace();
		}
	}
/*
	@Test
	void testLoginValidacao1() {
		autenticacao.getBd().getAlunos().add(joao);
		
		try {
			autenticacao.loginValidacao("1", joao.getLogin(), joao.getSenha());
		} catch (UsuarioInexistenteException e) {
			fail("Usuario inexistente erroneamente encontrado.");
			e.printStackTrace();
		} catch (EntradaInvalidaException e) {
			fail("Entrada invalida erroneamente encontrada.");
			e.printStackTrace();
		}
	}
*/
	@Test
	void testLoginValidacao2() {
		autenticacao.getBd().getAlunos().add(joao);

		try {
			autenticacao.loginValidacao("1", "joao12", joao.getSenha());
			fail("Usuario inexistente indevidamente encontrado.");
		} catch (UsuarioInexistenteException e) {
			e.printStackTrace();
		} catch (EntradaInvalidaException e) {
			fail("Entrada invalida erroneamente encontrada.");
			e.printStackTrace();
		}
	}
	
	@Test
	void testLoginValidacao3() {
		autenticacao.getBd().getAlunos().add(joao);

		try {
			autenticacao.loginValidacao("a", joao.getLogin(), joao.getSenha());
			fail("Entrada invalida indevidamente encontrada.");
		} catch (UsuarioInexistenteException e) {
			fail("Usuario inexistente erroneamente encontrado.");
			e.printStackTrace();
		} catch (EntradaInvalidaException e) {
			e.printStackTrace();
		}
	}
}
