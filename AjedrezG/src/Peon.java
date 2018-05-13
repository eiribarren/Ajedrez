
import java.awt.Dimension;
import java.awt.Color;

/**
 * Esta clase instancia a un peon con sus respectivos atributos y movimientos
 * @author jan_6
 *
 */
public class Peon extends Pieza{
	private int columnaInicial;
	private int filaInicial;
	public Peon(Color color, int fila, int columna) {
		this.columna = columna;
		this.fila = fila;
		this.columnaInicial = columna;
		this.filaInicial = fila;
		this.identificador = "Peon";
		this.color = color;
		this.setVisible(true);
		if ( color == Color.BLACK ) {
			this.urlImagen = "/PeonNegro.png";
		} else {
			this.urlImagen = "/PeonBlanc.png";
		}
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlImagen)));
		this.setPreferredSize(new Dimension(50,50));
		start();
	}

	/**
	 * Funcion que recoge una matriz con todos los movimientos posibles de un peon,
	 *  Primero define una matriz con los movimientos, crea un multiplicador que hara que las piezas esten abajo (jugador 1)
	 * o esten arriba (jugador 2), despues ira a�adiendo los movimientos posibles,
	 *  hay un IF que comprueba si la pieza esta en su posicion inicial, en tal  caso podra moverse dos casillas hacia adelante.
	 *  
	 *  @return devuelve la matriz de movimientos
	 */
	public int[][] getMovimientos(){
		int[][] movimientos = new int[4][2];
		int multiplicador;
		if ( this.color == Color.WHITE ) {
			multiplicador = -1;
		} else {
			multiplicador = 1;
		}
		movimientos[0][0] = this.fila + (1 * multiplicador);
		movimientos[0][1] = this.columna;
		if ( this.columna == this.columnaInicial && this.fila == this.filaInicial) {
			movimientos[1][0] = this.fila + (2 * multiplicador);
			movimientos[1][1] = this.columna;
		} else {
			movimientos[1][0] = -1;
			movimientos[1][1] = -1;
		}
		movimientos[2][0] = this.fila + ( 1 * multiplicador );
		movimientos[2][1] = this.columna + 1;
		
		movimientos[3][0] = this.fila + ( 1 * multiplicador );
		movimientos[3][1] = this.columna - 1;
		
		return movimientos;
	}
	
}

