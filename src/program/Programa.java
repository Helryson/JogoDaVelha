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
				}
				else {
					System.out.println();
					System.out.print("Vez do O, indique a posição: ");
				}
				jogo.marcaTabAux(sc);
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
		}
		catch(NumberFormatException e) {
			System.out.println("Error: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			jogo.printJogo();
		}
	}

}
