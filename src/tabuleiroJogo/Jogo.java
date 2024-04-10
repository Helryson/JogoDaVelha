package tabuleiroJogo;

import java.util.Scanner;

import tabuleiro.Position;
import tabuleiro.Tabuleiro;

public class Jogo {

	private int turno = 0;
	public boolean checkaVitoria;
	private String vencedor;
	private Tabuleiro tabuleiro = new Tabuleiro();

	public Jogo() {
	}	
	
	public int getTurno() {
		return turno;
	}

	public boolean isCheckaVitoria() {
		return checkaVitoria;
	}
	
	public String getVencedor() {
		return vencedor;
	}
	
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
	public void printJogo() {
		System.out.println();
		for(int i=0; i<3; i++) {
			System.out.print((0 + i) + "  ");
			for(int j=0; j<3; j++) {
				
				//Acessando ao contrário com j e dps i pois assim fica melhor para o jogador definir a posição desejada
				if(tabuleiro.getMarca()[j][i] != null) {
					System.out.print(tabuleiro.getMarca()[j][i].toString() + " ");
				}
				else {
					System.out.print("- ");
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("   0 1 2");
	}

	public void testaVitoria() {
		
		//X começa no turno 0, se o turno for par(vez do X) entao irá verificar primeiro as colunas e depois ira verificar as linhas
		if(turno % 2 == 0) {
			for (int i = 0; i < 3; i++) {
				if (tabuleiro.getMarca()[i][0] instanceof Xs && tabuleiro.getMarca()[i][1] instanceof Xs && tabuleiro.getMarca()[i][2] instanceof Xs) {
					checkaVitoria = true;
					vencedor = "X";
				}
				if (tabuleiro.getMarca()[0][i] instanceof Xs && tabuleiro.getMarca()[1][i] instanceof Xs && tabuleiro.getMarca()[2][i] instanceof Xs) {
					checkaVitoria = true;
					vencedor = "X";
				}
			}
			
			//Irá verificar as diagonais
			if (tabuleiro.getMarca()[0][0] instanceof Xs && tabuleiro.getMarca()[1][1] instanceof Xs && tabuleiro.getMarca()[2][2] instanceof Xs) {
				checkaVitoria = true;
				vencedor = "X";
			}
			if (tabuleiro.getMarca()[0][2] instanceof Xs && tabuleiro.getMarca()[1][1] instanceof Xs && tabuleiro.getMarca()[2][0] instanceof Xs) {
				checkaVitoria = true;
				vencedor = "X";
			}
		}
		
		else {
			for (int i = 0; i < 3; i++) {
				if (tabuleiro.getMarca()[i][0] instanceof Os && tabuleiro.getMarca()[i][1] instanceof Os && tabuleiro.getMarca()[i][2] instanceof Os) {
					checkaVitoria = true;
					vencedor = "O";
				}
				if (tabuleiro.getMarca()[0][i] instanceof Os && tabuleiro.getMarca()[1][i] instanceof Os && tabuleiro.getMarca()[2][i] instanceof Os) {
					checkaVitoria = true;
					vencedor = "O";
				}
			}
			
			if (tabuleiro.getMarca()[0][0] instanceof Os && tabuleiro.getMarca()[1][1] instanceof Os && tabuleiro.getMarca()[2][2] instanceof Os) {
				checkaVitoria = true;
				vencedor = "O";
			}
			if (tabuleiro.getMarca()[0][2] instanceof Os && tabuleiro.getMarca()[1][1] instanceof Os && tabuleiro.getMarca()[2][0] instanceof Os) {
				checkaVitoria = true;
				vencedor = "O";
			}
		}
		
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
	
	public void marcaTabAux(Scanner sc) {
		String input = sc.nextLine();
		
		
		//Verifica se o input contém mais do que dois caracteres
		if(input.length() == 2){
			String aux = input.substring(0, 1);
			String aux1 = input.substring(1);
			int row = Integer.parseInt(aux);
			int column = Integer.parseInt(aux1);
			marcaTabuleiro(row, column);
		}
		else {
			throw new JogoException("Número inválido, tente uma coordenada válida");
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
