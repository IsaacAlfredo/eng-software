package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.Aluno;
import application.BancoDeDados;
import application.Disciplina;
import application.Professor;
import exceptions.LoginExistenteException;
import exceptions.SenhaInvalidaException;

class BancoDeDadosTest {
	
	private BancoDeDados bd = new BancoDeDados();
	private Aluno a1 = new Aluno("a1","loginA1","senhaA1");
	private Aluno a2 = new Aluno("a2","loginA2","senhaA2");
	private Professor p1 = new Professor("p1","loginP1","senhaP1");
	private Professor p2 = new Professor("p2","loginP2","senhaP2");
	private Disciplina d1 = new Disciplina("d1","p1","ementa 1");
	private Disciplina d2 = new Disciplina("d2","p2","ementa 2");

	@BeforeEach
	 void setUp(){
		try {
			bd.cadastrarAluno(a1);
			a1.gerarMatriculaTemplateMethod(1, 2022);

			bd.cadastrarProfessor(p1);
			p1.gerarMatriculaTemplateMethod(1, 2022);

		} catch (LoginExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testCadastrarAluno1() {
		try {
			bd.cadastrarAluno(a1);
			fail("Login existente foi erroneamente aceito.");
		} catch (LoginExistenteException e) {
			e.printStackTrace();
		}
	}
	@Test
	void testCadastrarAluno2() {
		try {
			bd.cadastrarAluno(a2);
		} catch (LoginExistenteException e) {
			fail("Login existente foi indevidamente encontrado.");
		}
	}

	@Test
	void testConsultarAluno1() {
		assertEquals(bd.consultarAluno(a1),true);	
	}
	@Test
	void testConsultarAluno2() {
		assertEquals(bd.consultarAluno(a2),false);	
	}

	@Test
	void testRecuperarMatriculasAlunos() {
		try {
			bd.cadastrarAluno(a2);
			a2.gerarMatriculaTemplateMethod(2, 2022);
			
			ArrayList<String> matriculasAlunos = new ArrayList<String>();
			matriculasAlunos.add(a1.getMatricula());
			matriculasAlunos.add(a2.getMatricula());
			
			assertEquals(matriculasAlunos,bd.recuperarMatriculasAlunos());
		} catch (LoginExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Test
	void testCadastrarProfessor1() {
		assertEquals(bd.getProfessores().contains(p1),true);
	}
	@Test
	void testCadastrarProfessor2() {
		assertEquals(bd.getProfessores().contains(p2),false);
	}

	@Test
	void testConsultarProfessor1() {
		assertEquals(bd.consultarProfessor(p1),true);	
	}
	@Test
	void testConsultarProfessor2() {
		assertEquals(bd.consultarProfessor(p2),false);	
	}
	@Test
	void testRecuperarMatriculasProfessores() {
		try {
			bd.cadastrarProfessor(p2);
			p2.gerarMatriculaTemplateMethod(2, 2022);
			
			ArrayList<String> matriculasProfessores = new ArrayList<String>();
			matriculasProfessores.add(p1.getMatricula());
			matriculasProfessores.add(p2.getMatricula());
			
			assertEquals(matriculasProfessores,bd.recuperarMatriculasProfessores());
		} catch (LoginExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testConsultarLogin1() {
		
		assertEquals(bd.consultarLogin(a1.getLogin()),true);
	}
	@Test
	void testConsultarLogin2() {
		
		assertEquals(bd.consultarLogin(p1.getLogin()),true);
	}
	@Test
	void testConsultarLogin3() {
		
		assertEquals(bd.consultarLogin(a2.getLogin()),false);
	}
	
	@Test
	void testValidarSenhaProfessor1() {
				
		try {
			bd.validarSenhaProfessor(p1.getLogin(), p1.getSenha());
		} catch (SenhaInvalidaException e) {
			fail("Senha indevidamente invalida.");
			e.printStackTrace();
		}
	}

	@Test
	void testValidarSenhaProfessor2() {
		
		try {
			bd.validarSenhaProfessor(p1.getLogin(), p2.getSenha());
			fail("Senha erroneamente valida.");
		} catch (SenhaInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testValidarSenhaAluno1() {
		
		try {
			bd.validarSenhaAluno(a1.getLogin(), a1.getSenha());
		} catch (SenhaInvalidaException e) {
			fail("Senha indevidamente invalida.");
			e.printStackTrace();
		}
	}

	
	@Test
	void testValidarSenhaAluno2() {
		
		try {
			bd.validarSenhaAluno(a1.getLogin(), a2.getSenha());
			fail("Senha erroneamente valida.");
		} catch (SenhaInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	void testCadastrarDisciplina() {
		bd.cadastrarDisciplina(d1);
		
		assertEquals(bd.getDisciplinas().contains(d1),true);
	}
	@Test
	void testCadastrarDisciplina2() {
		bd.cadastrarDisciplina(d1);
		
		assertEquals(bd.getDisciplinas().contains(d2),false);
	}

}
