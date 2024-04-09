package tabuleiro;

public class Marca {
	
	protected Position position;
	private Tabuleiro tabuleiro;
	
	public Marca(Tabuleiro tabuleiro) {
		this.position = null;
		this.tabuleiro = tabuleiro;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
}
