package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.Aluno;
import application.BancoDeDados;
import application.Disciplina;
import application.MenuUsuarioFacade;
import application.Professor;
import exceptions.AlunoMatriculadoException;
import exceptions.EntradaInvalidaException;

class MenuUsuarioFacadeTest {
	
	MenuUsuarioFacade muf = new MenuUsuarioFacade();
	BancoDeDados bd = new BancoDeDados();
	Professor p1 = new Professor("p1","p1","p1");
	Aluno a1 = new Aluno("a1","a1","a1");
	Disciplina d1 = new Disciplina("d1","d1","d1");
	Disciplina d2 = new Disciplina("d2","d2","d2");


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCriarDisciplina1() {
		bd.getProfessores().add(p1);
		muf.setProfessor(p1.getLogin(), bd);

		muf.criarDisciplina(d1, bd);
		assertEquals(muf.getProfessor().getDisciplinas().contains(d1),true);
	}
	
	@Test
	void testCriarDisciplina2() {
		bd.getProfessores().add(p1);
		muf.setProfessor(p1.getLogin(), bd);

		muf.criarDisciplina(d1, bd);
		assertEquals(muf.getProfessor().getDisciplinas().contains(d2),false);
	}

	@Test
	void testMatricularAluno1() {
		bd.getAlunos().add(a1);
		muf.setAluno(a1.getLogin(), bd);
		bd.getDisciplinas().add(d1);
		
		try {
			muf.MatricularAluno("1", bd);
			assertEquals(a1.getDisciplinas().contains(d1),true);
		} catch (AlunoMatriculadoException e) {
			fail("Aluno indevidamente nao matriculado");
			e.printStackTrace();
		}
	}
	@Test
	void testMatricularAluno2() {
		bd.getAlunos().add(a1);
		muf.setAluno(a1.getLogin(), bd);
		bd.getDisciplinas().add(d1);
		
		try {
			muf.MatricularAluno("1", bd);
			muf.MatricularAluno("1", bd);
			fail("Aluno erroneamente matriculado");
		} catch (AlunoMatriculadoException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testMatricularAluno3() {
		bd.getAlunos().add(a1);
		muf.setAluno(a1.getLogin(), bd);
		bd.getDisciplinas().add(d1);
		
		try {
			muf.MatricularAluno("a", bd);
			assertEquals(a1.getDisciplinas().contains(d1),false);
		} catch (AlunoMatriculadoException e) {
			e.printStackTrace();
			fail("Aluno indevidamente nao matriculado");
		}
	}
	

}
