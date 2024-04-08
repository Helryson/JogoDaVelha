package tabuleiroJogo;

import tabuleiro.Tabuleiro;

public class Jogo {

	private int turn = 0;
	private boolean checkaVitoria;
	Tabuleiro tabuleiro = new Tabuleiro();

	public Jogo() {
	}

	public void testaVitoria() {
		
		for (int i = 0; i < 3; i++) {
			if (tabuleiro.getMarca()[i][0] instanceof Xs && tabuleiro.getMarca()[i][1] instanceof Xs && tabuleiro.getMarca()[i][2] instanceof Xs) {
				checkaVitoria = true;
			}
			if (tabuleiro.getMarca()[0][i] instanceof Xs && tabuleiro.getMarca()[1][i] instanceof Xs && tabuleiro.getMarca()[2][i] instanceof Xs) {
				checkaVitoria = true;
			}
		}
		
		if (tabuleiro.getMarca()[0][0] instanceof Xs && tabuleiro.getMarca()[1][1] instanceof Xs && tabuleiro.getMarca()[2][2] instanceof Xs) {
			checkaVitoria = true;
		}
		if (tabuleiro.getMarca()[0][2] instanceof Xs && tabuleiro.getMarca()[1][1] instanceof Xs && tabuleiro.getMarca()[2][0] instanceof Xs) {
			checkaVitoria = true;
		}

		checkaVitoria = false;
	}

}
