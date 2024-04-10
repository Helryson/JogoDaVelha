package tabuleiro;

public class Tabuleiro {

	private int linha;
	private int coluna;
	private Marca[][] marca;
	
	public Tabuleiro() {
		this.linha = 3;
		this.coluna = 3;
		marca = new Marca[linha][coluna];
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public Marca[][] getMarca() {
		return marca;
	}
	
	
	public Marca marca(int linha, int coluna) {
		if(!positionExiste(linha, coluna)) {
			throw new TabuleiroException("Posição indicada não existe no tabuleiro");
		}
		return marca[linha][coluna];
	}
	
	
	//Retorna a posição da marca se ela existir
	public Marca marca(Position position) {
		if(!positionExiste(position)) {
			throw new TabuleiroException("Posição indicada não existe no tabuleiro");
		}
		return marca[position.getLinha()][position.getColuna()];
	}
	
	//Verifica se a linha e a coluna existe dentro dos limites no tabuleiro
	public boolean positionExiste(int row, int column) {
		return row >= 0 && row < linha && column >= 0 && column < coluna;
	}
	
	public boolean positionExiste(Position position) {
		return positionExiste(position.getLinha(), position.getColuna());
	}
	
	public boolean casaOcupada(Position position) {
		if(!positionExiste(position)) {
			throw new TabuleiroException("Posição indicada não existe no tabuleiro");
		}
		return marca(position) != null;
	}
	
	public void marcaPosition(Position position, Marca marcas) {
		if(casaOcupada(position)) {
			throw new TabuleiroException("Posição " + position.toString() + " já ocupada");
		}
		marca[position.getLinha()][position.getColuna()] = marcas;
		marcas.position = position;
	}
	
}
