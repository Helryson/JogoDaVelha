package program;

import java.util.Scanner;

import tabuleiro.TabuleiroException;
import tabuleiroJogo.Jogo;
import tabuleiroJogo.JogoException;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Jogo jogo = new Jogo();
		
		try {
			while(!jogo.checkaVitoria || !jogo.estaCheio()) {
				jogo.printJogo();
				System.out.print("Vez do X, indique a posição: ");
				jogo.marcaTabAux(sc);
				jogo.testaVitoria();
				jogo.estaCheio();
				PrintAux.limpaTela();
			}
		}
		catch(TabuleiroException e) {
			System.out.println("Error: " + e.getMessage());
		}
		catch(NumberFormatException e) {
			System.out.println("Error: Insira uma coordenada válida");
		}
		catch(JogoException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
}
