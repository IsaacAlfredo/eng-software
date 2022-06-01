package application;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SEV {
	
	public static void main(String[] args) {
		
		/*prototipo do cadastro, ainda a ser atualizado*/
		Scanner scanner = new Scanner(System.in);
		String tipoUsuario = "Aluno";
		List<String> matriculas;

		System.out.println("Nome: ");
		String nome = scanner.nextLine();
		
		System.out.println("login: ");
		String login = scanner.nextLine();
		
		System.out.println("senha: ");
		String senha = scanner.nextLine();
		
		Aluno aluno = new Aluno(nome,login,senha);
		
		matriculas = new ArrayList<String>();
		
		aluno.gerarMatricula(tipoUsuario,matriculas);
		System.out.println("Sua matrícula é: ");
		System.out.println(aluno.getMatricula());

		
		
		}
	
}
