package tabuleiroJogo;

import tabuleiro.Marca;
import tabuleiro.Tabuleiro;

public class Xs extends Marca{

	private Cor cor = Cor.AZUL;
	
	public Xs(Tabuleiro tabuleiro) {
		super(tabuleiro);
	}
	
	@Override
	public String toString() {
		return "X";
	}
	
}
