package application;

import java.util.Scanner;

import exceptions.EntradaInvalidaException;

public class SEV {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AutenticacaoFacade autenticacao = new AutenticacaoFacade();
		boolean sistemaFlag = true;
		
		while(sistemaFlag) {
		System.out.println("Bem-vindo!\nSelecione uma opcao no menu:\n0- Sair\n1- Login\n2- Cadastro\n===============================================================");
		try {
			String opcao1 = scanner.nextLine();
			
			switch(opcao1){
				case "0":
					sistemaFlag = false;
					break;
				case "1":
					autenticacao.login();
					break;
				case "2":
					autenticacao.cadastro();
					break;
				default:
					throw new EntradaInvalidaException();
				
			}
		}
		catch(EntradaInvalidaException eie) {
			System.out.println(eie.getMessage()+ "\n===============================================================");
			}
		}
	}
}
