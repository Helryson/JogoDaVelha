package tabuleiroJogo;

import tabuleiro.Marca;
import tabuleiro.Tabuleiro;

public class Os extends Marca{
	
	private Cor cor = Cor.VERMELHO;
	
	public Os(Tabuleiro tabuleiro) {
		super(tabuleiro);
	}

	@Override
	public String toString() {
		return "O";
	}

}
