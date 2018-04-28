package Juego;
import java.awt.Dimension;
import java.awt.Color;

public class Alfil extends Pieza{
	public Alfil(Color color) {
		this.setVisible(true);
		if ( color == Color.BLACK ) {
			this.urlImagen = "/Juego/AlfilNegro.png";
		} else {
			this.urlImagen = "/Juego/AlfilBlanco.png";
		}
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlImagen)));
		this.setPreferredSize(new Dimension(100,100));
	}
	public int[][] getMovimientos(){
		int[][] movimientos = new int[2][2];
		return movimientos;
	}
}

