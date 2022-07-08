package application;

import java.util.Calendar;
import java.util.Scanner;

import exceptions.EntradaInvalidaException;
import exceptions.LoginExistenteException;
import exceptions.SenhaInvalidaException;
import exceptions.UsuarioInexistenteException;

public class AutenticacaoFacade {
	private Scanner scanner = new Scanner(System.in);
	private BancoDeDados bd = new BancoDeDados();
	private MenuUsuarioFacade menuUsuario = new MenuUsuarioFacade();
	private boolean cadastroFlag;
	private boolean loginFlag;
		
	
	public boolean getCadastroFlag() {
		return cadastroFlag;
	}
	public void setCadastroFlag(boolean cadastroFlag) {
		this.cadastroFlag = cadastroFlag;
	}
	public boolean getLoginFlag() {
		return loginFlag;
	}
	public void setLoginFlag(boolean loginFlag) {
		this.loginFlag = loginFlag;
	}
	public Scanner getScanner() {
		return scanner;
	}
	public BancoDeDados getBd() {
		return bd;
	}
	public void setBd(BancoDeDados bd) {
		this.bd = bd;
	}
	
	public MenuUsuarioFacade getMenuUsuario() {
		return menuUsuario;
	}
	public void setMenuUsuario(MenuUsuarioFacade menuUsuario) {
		this.menuUsuario = menuUsuario;
	}

	public AutenticacaoFacade(){
	}
	public void cadastro() {
		
		this.setCadastroFlag(true);
		
		while(this.getCadastroFlag() == true) {
			System.out.println("Voce e um:\n0- Sair\n1- Aluno\n2- Professor\n===============================================================");
			String tipoUsuario = this.getScanner().nextLine();
			
			String nome = "";
			String login = "";
			String senha = "";
			
			if(tipoUsuario.equals("1") || tipoUsuario.equals("2")) {
				System.out.println("Nome: ");
				nome = this.getScanner().nextLine();
				System.out.println("login: ");
				login = this.getScanner().nextLine();
				System.out.println("senha: ");
				senha = this.getScanner().nextLine();
			}
			
			try {
				this.CadastroValidacao(tipoUsuario, nome, login, senha);
			} catch (EntradaInvalidaException eie) {
				System.out.println(eie.getMessage()+"\n===============================================================");
			}		
		}		
	}
	
	public void CadastroValidacao(String tipoUsuario,String nome,String login,String senha) throws EntradaInvalidaException{
		switch(tipoUsuario) {
		case "1":
			
			Aluno aluno = new Aluno(nome,login,senha);
			try {
				this.getBd().cadastrarAluno(aluno);
				aluno.gerarMatriculaTemplateMethod(this.getBd().recuperarMatriculasAlunos().size(),Calendar.getInstance().get(Calendar.YEAR));
				this.setCadastroFlag(false);
			} catch (LoginExistenteException lee) {
				System.out.println(lee.getMessage()+"\n===============================================================");
			}
			
			break;
		case "2":
			Professor professor = new Professor(nome,login,senha);
			try {
				this.getBd().cadastrarProfessor(professor);
				professor.gerarMatriculaTemplateMethod(this.getBd().recuperarMatriculasProfessores().size(),Calendar.getInstance().get(Calendar.YEAR));
				this.setCadastroFlag(false);
			} catch (LoginExistenteException lee) {
				System.out.println(lee.getMessage()+"\n===============================================================");
			}
			break;
		case "0":
			this.setCadastroFlag(false);
			break;
		default:
			throw new EntradaInvalidaException();
		}
	}
	
	public void login() {
		
		this.setLoginFlag(true);
		
		while(this.getLoginFlag() == true) {
			System.out.println("Voce e aluno ou professor?\n0- Sair\n1- Aluno\n2-Professor\n===============================================================");
			String tipoUsuario = this.getScanner().nextLine();
			
			String login = "";
			String senha = "";
			
			if(tipoUsuario.equals("1") || tipoUsuario.equals("2")) {
				System.out.println("login: ");
				login = this.getScanner().nextLine();
				System.out.println("senha: ");
				senha = this.getScanner().nextLine();
			}
			
			try {
				this.loginValidacao(tipoUsuario, login, senha);
			} catch (UsuarioInexistenteException uie) {
				System.out.println(uie.getMessage() + "\n===============================================================");		

			} catch (EntradaInvalidaException eie) {
				System.out.println(eie.getMessage() + "\n===============================================================");		
			}
		}
	}
	public void loginValidacao(String tipoUsuario, String login, String senha) throws UsuarioInexistenteException,EntradaInvalidaException{
		
		
		if (this.getBd().consultarLogin(login) == false && !tipoUsuario.equals("0")) {
			throw new UsuarioInexistenteException();
		}
		else {
			switch(tipoUsuario) {
			case "1":
				try {
					if(this.getBd().validarSenhaAluno(login, senha) == true) {
						System.out.println("Login realizado com sucesso como Aluno\n===============================================================");
						this.getMenuUsuario().MenuAluno(this.getBd(), login);
						this.setLoginFlag(false);
					}
				} catch (SenhaInvalidaException sie) {
					System.out.println(sie.getMessage() + "\n===============================================================");		
				}
				break;
			case "2":
				try {
					if(this.getBd().validarSenhaProfessor(login, senha) == true) {
						this.getMenuUsuario().MenuProfessor(this.getBd(), login);
						this.setLoginFlag(false);
						
					}
				} catch (SenhaInvalidaException sie) {
					System.out.println(sie.getMessage() + "\n===============================================================");		
				}
				break;
			case "0":
				this.setLoginFlag(false);
				break;
			default:
				throw new EntradaInvalidaException();
			}
		}
	}
}
