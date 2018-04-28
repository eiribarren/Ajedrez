package Juego;
import java.awt.Dimension;
import java.awt.Color;

public class Caballo extends Pieza{
	public Caballo(Color color) {
		this.setVisible(true);
		if ( color == Color.BLACK ) {
			this.urlImagen = "/Juego/CaballoNegro.png";
		} else {
			this.urlImagen = "/Juego/CaballoBlanco.png";
		}
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlImagen)));
		this.setPreferredSize(new Dimension(100,100));
	}
	public int[][] getMovimientos(){
		int[][] movimientos = new int[2][2];
		return movimientos;
	}
}

