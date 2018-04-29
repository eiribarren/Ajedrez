package Juego;
import java.awt.Dimension;
import java.awt.Color;

public class Peon extends Pieza{
	private int posicionXInicial;
	private int posicionYInicial;
	public Peon(Color color, int posicionY, int posicionX) {
		this.identificador = "Peon";
		this.posicionY = posicionY;
		this.posicionX = posicionX;
		this.posicionXInicial = posicionX;
		this.posicionYInicial = posicionY;
		this.color = color;
		this.setVisible(true);
		if ( color == Color.BLACK ) {
			this.urlImagen = "/Juego/PeonNegro.png";
		} else {
			this.urlImagen = "/Juego/PeonBlanc.png";
		}
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlImagen)));
		this.setPreferredSize(new Dimension(100,100));
		start();
	}
	
	public int[][] getMovimientos(){
		int[][] movimientos = new int[2][2];
		int multiplicador;
		if ( this.color == Color.WHITE ) {
			multiplicador = -1;
		} else {
			multiplicador = 1;
		}
		movimientos[0][0] = this.posicionY + (1 * multiplicador);
		movimientos[0][1] = this.posicionX;
		if ( this.posicionX == this.posicionXInicial && this.posicionY == this.posicionYInicial) {
			movimientos[1][0] = this.posicionY + (2 * multiplicador);
			movimientos[1][1] = this.posicionX;
		} else {
			movimientos[1][0] = -1;
			movimientos[1][1] = -1;
		}
		
		return movimientos;
	}
	
}

