package program;

public class PrintAux {

	public static void limpaTela() {
		System.out.println("\033[H\033[2J");
		System.out.flush();
	}
	
}
