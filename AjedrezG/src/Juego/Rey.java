package Juego;
import java.awt.Dimension;
import java.awt.Color;

public class Rey extends Pieza{
	public Rey(Color color, int fila, int columna) {
		this.identificador = "Rey";
		this.columna = columna;
		this.fila = fila;
		this.color = color;
		this.setVisible(true);
		if ( color == Color.BLACK ) {
			this.urlImagen = "/Juego/ReyNegro.png";
		} else {
			this.urlImagen = "/Juego/ReyBlanco.png";
		}
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlImagen)));
		this.setPreferredSize(new Dimension(100,100));
	}
	public int[][] getMovimientos(){
		int[][] movimientos = new int[8][2];
			movimientos[0][0]=getFila()+1;
			movimientos[0][1]=getColumna();
			
			movimientos[1][0]=getFila()-1;
			movimientos[1][1]=getColumna();
		
			movimientos[2][0]=getFila();
			movimientos[2][1]=getColumna()+1;
			
			movimientos[3][0]=getFila();
			movimientos[3][1]=getColumna()-1;
			
			movimientos[4][0]=getFila()+1;
			movimientos[4][1]=getColumna()+1;
			
			movimientos[5][0]=getFila()+1;
			movimientos[5][1]=getColumna()-1;
			
			movimientos[6][0]=getFila()-1;
			movimientos[6][1]=getColumna()+1;
			
			movimientos[7][0]=getFila()-1;
			movimientos[7][1]=getColumna()-1;
		return movimientos;
	}
}

