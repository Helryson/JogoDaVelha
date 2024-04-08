package tabuleiroJogo;

import tabuleiro.Marca;
import tabuleiro.Tabuleiro;

public class Os extends Marca{
	
	public Os(Tabuleiro tabuleiro) {
		super(tabuleiro);
	}

	private Cor cor = Cor.VERMELHO;
	
	@Override
	public String toString() {
		return "Q";
	}

}
