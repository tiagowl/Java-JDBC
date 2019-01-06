package Tiago.Pratica;

public class Game {

	public int id;
	public String nome;
	public String categoria;
	public String console;
	public Double preco;
	
	public Game() {
	
	}
	
	public Game(String nome, String categoria, String console, Double preco ) {
		this.nome = nome;
		this.categoria = categoria;
		this.console = console;
		this.preco = preco;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		this.console = console;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	
}
