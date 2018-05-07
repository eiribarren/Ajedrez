
import java.awt.Dimension;
import java.awt.Color;

public class Alfil extends Pieza{
	public Alfil(Color color, int fila, int columna) {
		this.identificador = "Alfil";
		this.columna = columna;
		this.fila = fila;
		this.color = color;
		this.setVisible(true);
		if ( color == Color.BLACK ) {
			this.urlImagen = "/AlfilNegro.png";
		} else {
			this.urlImagen = "/AlfilBlanco.png";
		}
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlImagen)));
		this.setPreferredSize(new Dimension(50,50));
		start();
	}
	public int[][] getMovimientos(){
		int[][] movimientos = new int[28][2];
		for(int i=1;i<8;i++){
			movimientos[i-1][0]=getFila()+(1*i);//moviment primer fila
			movimientos[i-1][1]=getColumna()+(1*i);//moviment primer columna
		}
		for(int i=1;i<8;i++){
			movimientos[i+6][0]=getFila()-(1*i);//moviment primer fila
			movimientos[i+6][1]=getColumna()+(1*i);//moviment primer columna
		}
		for(int i=1;i<8;i++){
			movimientos[i+13][0]=getFila()+(1*i);//moviment primer fila
			movimientos[i+13][1]=getColumna()-(1*i);//moviment primer columna
		}
		for(int i=1;i<8;i++){
			movimientos[i+20][0]=getFila()-(1*i);//moviment primer fila
			movimientos[i+20][1]=getColumna()-(1*i);//moviment primer columna
		}
		return movimientos;
	}
}

