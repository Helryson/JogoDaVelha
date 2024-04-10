package tabuleiro;

import tabuleiroJogo.JogoException;

public class Position {

	private int coluna;
	private int linha;
	
	public Position(int coluna, int linha) {
		if(linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
			throw new TabuleiroException("Casas permitidas são de 0 a 2");
		}
		this.coluna = coluna;
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}
	
	@Override
	public String toString() {
		return linha + ", " + coluna;
	}
	
}
