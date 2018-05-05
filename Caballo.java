package Juego;
import java.awt.Dimension;
import java.awt.Color;

public class Caballo extends Pieza{
	public Caballo(Color color, int fila, int columna) {
		this.identificador = "Caballo";
		this.columna = columna;
		this.fila = fila;
		this.color = color;
		this.setVisible(true);
		if ( color == Color.BLACK ) {
			this.urlImagen = "/Juego/CaballoNegro.png";
		} else {
			this.urlImagen = "/Juego/CaballoBlanco.png";
		}
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlImagen)));
		this.setPreferredSize(new Dimension(100,100));
		start();
	}
	//Columna=X Fila=Y
	public int[][] getMovimientos(){
		int[][] movimientos = new int[8][2];
			movimientos[0][0]=getFila()+2;//moviment primer fila
			movimientos[0][1]=getColumna()+1;//moviment primer columna
			
			movimientos[1][0]=getFila()+2; //moviment segon fila
			movimientos[1][1]=getColumna()-1; //moviment segon columna
			
			movimientos[2][0]=getFila()+1;//moviment primer fila
			movimientos[2][1]=getColumna()+2;//moviment primer columna
			
			movimientos[3][0]=getFila()-1; //moviment segon fila
			movimientos[3][1]=getColumna()+2; //moviment segon columna
			
			movimientos[4][0]=getFila()-2;//moviment primer fila
			movimientos[4][1]=getColumna()-1;//moviment primer columna
			
			movimientos[5][0]=getFila()+1; //moviment segon fila
			movimientos[5][1]=getColumna()-2; //moviment segon columna
			
			movimientos[6][0]=getFila()-1; //moviment segon fila
			movimientos[6][1]=getColumna()-2; //moviment segon columna
			
			movimientos[7][0]=getFila()+1; //moviment segon fila
			movimientos[7][1]=getColumna()-2; //moviment segon columna
			return movimientos;
	}
}

