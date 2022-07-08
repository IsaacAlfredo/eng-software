package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import application.BancoDeDados;
import application.Disciplina;
import application.Professor;
import exceptions.DisciplinaExistenteException;
import exceptions.LimiteDisciplinaException;

class ProfessorTest {
	private Professor p1 = new Professor("p1","loginP1","senhaP1");
	private Disciplina d1 = new Disciplina("d1","p1","ementa 1");
	private Disciplina d2 = new Disciplina("d2","p2","ementa 2");
	private Disciplina d3 = new Disciplina("d3","p3","ementa 3");
	private Disciplina d4 = new Disciplina("d4","p4","ementa 4");
	private Disciplina d5 = new Disciplina("d4","p4","ementa 4");
	private BancoDeDados bd = new BancoDeDados();
	
	@Test
	void testGerarMatriculaTemplateMethod() {
		p1.gerarMatriculaTemplateMethod(1, 2022);
		
		assertEquals(p1.getMatricula(),"PR122");
	}
	
	@Test
	void testDisciplinaExistente1() {
		p1.getDisciplinas().add(d1);
		
		try {
			p1.disciplinaExistente(d1);
			fail("Disciplina existente não encontrada");
		} catch (DisciplinaExistenteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testDisciplinaExistente2() {
		p1.getDisciplinas().add(d1);
		
		try {
			p1.disciplinaExistente(d2);
		} catch (DisciplinaExistenteException e) {
			fail("Disciplina inexistente foi apontada como existente");
			e.printStackTrace();
		}
	}
	@Test
	void testListarDisciplinas() {
		p1.getDisciplinas().add(d1);
		p1.getDisciplinas().add(d2);
		

		String lista = p1.getDisciplinas().indexOf(d1)+1 +"- "+ d1.getNome()+"\n";
		lista += p1.getDisciplinas().indexOf(d2)+1 +"- "+ d2.getNome()+"\n";
		
		assertEquals(p1.listarDisciplinas(),lista);

	}
	
	@Test
	void testAdicionarDisciplina1() {
		try {
			p1.adicionarDisciplina(d1, bd);
		} catch (LimiteDisciplinaException e) {
			fail("Limite erroneamente identificado");
			e.printStackTrace();
		}
	}
	@Test
	void testAdicionarDisciplina2() {
		try {
			p1.adicionarDisciplina(d2, bd);
			p1.adicionarDisciplina(d3, bd);
			p1.adicionarDisciplina(d4, bd);
			
			p1.adicionarDisciplina(d1, bd);
		} catch (LimiteDisciplinaException e) {
			fail("Limite erroneamente identificado");
			e.printStackTrace();
		}
	}
	@Test
	void testAdicionarDisciplina3() {
		try {
			p1.adicionarDisciplina(d2, bd);
			p1.adicionarDisciplina(d3, bd);
			p1.adicionarDisciplina(d4, bd);
			p1.adicionarDisciplina(d5, bd);
	
			p1.adicionarDisciplina(d1, bd);
			
			fail("Disciplina adicionada além do limite");
		} catch (LimiteDisciplinaException e) {
			e.printStackTrace();
		}
	}

}
