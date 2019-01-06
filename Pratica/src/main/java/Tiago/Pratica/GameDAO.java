package Tiago.Pratica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Tiago.Pratica.ConnectionFactory;


public class GameDAO {

	private Connection connection = null;
	private java.sql.PreparedStatement statment = null;
	
	public GameDAO() {
		connection = new ConnectionFactory().getConnetion();	

	}
	
	public Game findById(int id) throws SQLException {
		String query = "SELECT * FROM games WHERE id = ?";
		statment = connection.prepareStatement(query); 
    	statment.setInt(1, id);
    	ResultSet res = statment.executeQuery(query);
    	
    	Game game = null;
    	
    	while(res.next()) {
    		game = new Game(res.getString("nome"), res.getString("categoria"), res.getString("console"), res.getDouble("preco")); 
    	}
    	
    	return game;
	}
	
	public List<Game> findByCathegory() throws SQLException{

		String query = "SELECT * FROM games WHERE categoria = ";
		List<Game> games = new ArrayList<Game>();
		statment = connection.prepareStatement(query); 
    	ResultSet res = statment.executeQuery();
    	
	while(res.next()) {
		games.add(new Game(res.getString("nome"), res.getString("categoria"), res.getString("console"), res.getDouble("preco")));
	}
    	
	return games;
	}
	
	public List<Game> findAll() throws SQLException{
		String query = "SELECT * FROM games";
		List<Game> games = new ArrayList<Game>();
		statment = connection.prepareStatement(query); 
    	ResultSet res = statment.executeQuery();
    	
	while(res.next()) {
		games.add(new Game(res.getString("nome"), res.getString("categoria"), res.getString("console"), res.getDouble("preco")));
	}
    	
	return games;
	}
	
	 public void insert(Game game) throws SQLException {
	    	String query = "INSERT INTO games (nome, categoria, console, preco) values (?, ?, ?, ?)";
	    	statment = connection.prepareStatement(query);
	    	statment.setString(1, game.getNome());
	    	statment.setString(2, game.getCategoria());
	    	statment.setString(3, game.getConsole());
	    	statment.setDouble(4, game.getPreco());
	    	statment.execute();
	    }
	

	
	
	
}
