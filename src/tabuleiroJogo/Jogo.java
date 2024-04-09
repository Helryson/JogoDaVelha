package tabuleiroJogo;

import tabuleiro.Position;
import tabuleiro.Tabuleiro;

public class Jogo {

	private int turno = 0;
	public boolean checkaVitoria;
	Tabuleiro tabuleiro = new Tabuleiro();

	public Jogo() {
	}
	
	public void clearScreen() {
		System.out.println("\033[H\033[2J");
		System.out.flush();
	}
	
	public void printJogo() {
		System.out.println();
		for(int i=0; i<3; i++) {
			System.out.print((0 + i) + "  ");
			for(int j=0; j<3; j++) {
				if(tabuleiro.getMarca()[i][j] == null) {
					System.out.println(" ");
				}
				else {
					System.out.println(tabuleiro.getMarca()[i][j].toString());
				}
				if(j < 2) {
					System.out.println("|");
				}
			}
			if(i < 2) {
				System.out.println("_");
			}
		}
		
		System.out.println();
		System.out.println("  0 1 2");
	}

	public void testaVitoria() {
		
		if(turno % 2 == 0) {
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
		}
		
		else {
			for (int i = 0; i < 3; i++) {
				if (tabuleiro.getMarca()[i][0] instanceof Os && tabuleiro.getMarca()[i][1] instanceof Os && tabuleiro.getMarca()[i][2] instanceof Os) {
					checkaVitoria = true;
				}
				if (tabuleiro.getMarca()[0][i] instanceof Os && tabuleiro.getMarca()[1][i] instanceof Os && tabuleiro.getMarca()[2][i] instanceof Os) {
					checkaVitoria = true;
				}
			}
			
			if (tabuleiro.getMarca()[0][0] instanceof Os && tabuleiro.getMarca()[1][1] instanceof Os && tabuleiro.getMarca()[2][2] instanceof Os) {
				checkaVitoria = true;
			}
			if (tabuleiro.getMarca()[0][2] instanceof Os && tabuleiro.getMarca()[1][1] instanceof Os && tabuleiro.getMarca()[2][0] instanceof Os) {
				checkaVitoria = true;
			}
		}

		checkaVitoria = false;
		turno++;
	}
	
	// turnos pares marcam X no tabuleiro, impares marcam O
	public void marcaTabuleiro(int linha, int coluna) {
		Position p = new Position(linha, coluna);
		
		Xs x = new Xs(tabuleiro);
		Os o = new Os(tabuleiro);
		
		tabuleiro.casaOcupada(p);
		
		if(turno % 2 == 0) {
			tabuleiro.marcaPosition(p, x);
		}
		else {
			tabuleiro.marcaPosition(p, o);
		}
	}
	

	public boolean estaCheio() {
		for(int i=0; i<tabuleiro.getLinha(); i++) {
			for(int j=0; j<tabuleiro.getColuna(); j++) {
				if(tabuleiro.getMarca()[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}

}
