package program;

import java.util.Scanner;

import tabuleiroJogo.Jogo;
import tabuleiroJogo.JogoException;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Jogo jogo = new Jogo();
		
		try {
			while(!jogo.checkaVitoria && !jogo.estaCheio()) {
				jogo.printJogo();
				if(jogo.getTurno() % 2 == 0) {
					System.out.println();
					System.out.print("Vez do X, indique a posição: ");
					jogo.marcaTabAux(sc);
				}
				else {
					jogo.minimax(jogo.getTabuleiro(), jogo.jogadasRestantes(), jogo.isMaximizingPlayer());
				}
				jogo.testaVitoria();
				
				PrintAux.limpaTela();
			}

			if(jogo.estaCheio()) {
				jogo.printJogo();
				System.out.println("EMPATE!!");
			}
			else {
				System.out.println("Vencedor: " + jogo.getVencedor());
			}
		}
		catch(JogoException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		catch(NumberFormatException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		catch(RuntimeException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		finally {
			jogo.printJogo();
		}
	}

}
