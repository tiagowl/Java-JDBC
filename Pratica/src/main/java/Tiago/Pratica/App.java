package Tiago.Pratica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;

/**
 * Hello world!
 *
 */
import java.util.Scanner;
import Tiago.Pratica.GameDAO;
import Tiago.Pratica.Game;


public class App 
{
	
static GameDAO game = new GameDAO();

private static Connection connection = null;
private static java.sql.PreparedStatement statment = null;
	
	
    public static void main( String[] args ) throws SQLException{
        
    	String texto = "\n======EliteGames======"
    			+ "\n1- Cadastrar"
    			+ "\n2- Listar Todos"
    			+ "\n Escolha: ";
    	while(true) {
    		
    		switch(teclado(texto)) {
    		case 1: cadastrar();break;
    		case 2: listarTodos();break;
    		}
    		
    	}
    	
    }



	private static void listarTodos() throws SQLException {
		
		List<Game> data = game.findAll();
		for(Game games : data) {
			System.out.println("Id: " +games.getId());
			System.out.println("Nome: " +games.getNome());
			System.out.println("Categoria: " +games.getCategoria());
			System.out.println("Console: " +games.getConsole());
			System.out.println("Preço: " +games.getPreco());
		}
	}

	private static void cadastrar() throws SQLException {
		
		System.out.println("Nome:");
		String nome = new Scanner(System.in).next();
		
		System.out.println("Categoria:");
		String categoria = new Scanner(System.in).next();
		
		System.out.println("Console:");
		String console = new Scanner(System.in).next();
		
		System.out.println("Preço:");
		Double preco = new Scanner(System.in).nextDouble();
		
		game.insert(new Game(nome, categoria, console, preco));
	}

	private static int teclado(String menu) {
		
	   System.out.println(menu);
	   return new Scanner(System.in).nextInt();
	}
}
