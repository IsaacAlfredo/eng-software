package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import application.Aluno;
import application.Disciplina;

class AlunoTest {
	private Aluno a1 = new Aluno("a1","loginA1","senhaA1");
	private Disciplina d1 = new Disciplina("d1","p1","ementa 1");
	private Disciplina d2 = new Disciplina("d2","p2","ementa 2");


	@Test
	void testGerarMatriculaTemplateMethod() {
		a1.gerarMatriculaTemplateMethod(1, 2022);
		assertEquals(a1.getMatricula(),"AL122");
	}
	
	@Test
	void testListarDisciplinas() {
		a1.getDisciplinas().add(d1);
		a1.getDisciplinas().add(d2);
		

		int indexDisciplina = a1.getDisciplinas().indexOf(d1)+1;
		String lista = indexDisciplina +"- "+ d1.getNome()+"\n";
		int indexDisciplina2 = a1.getDisciplinas().indexOf(d2)+1;
		lista += indexDisciplina2 +"- "+ d2.getNome()+"\n";

		
		assertEquals(a1.listarDisciplinas(),lista);
	}

}
