
import java.awt.Dimension;
import java.awt.Color;
/**
 * 
 * @author Andres
 *
 */
public class Alfil extends Pieza{
	public Alfil(Color color, int fila, int columna) {
		this.columna = columna;
		this.fila = fila;
		this.identificador = "Alfil";
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
		int[][] movimientosAlfil = new int[28][2];
		for(int i=1;i<8;i++){
			movimientosAlfil[i-1][0]=getFila()+(1*i);//moviment primer fila
			movimientosAlfil[i-1][1]=getColumna()+(1*i);//moviment primer columna
		}
		for(int i=1;i<8;i++){
			movimientosAlfil[i+6][0]=getFila()-(1*i);//moviment segon fila
			movimientosAlfil[i+6][1]=getColumna()+(1*i);//moviment segon columna
		}
		for(int i=1;i<8;i++){
			movimientosAlfil[i+13][0]=getFila()+(1*i);//moviment tercer fila
			movimientosAlfil[i+13][1]=getColumna()-(1*i);//moviment tercer columna
		}
		for(int i=1;i<8;i++){
			movimientosAlfil[i+20][0]=getFila()-(1*i);//moviment quart fila
			movimientosAlfil[i+20][1]=getColumna()-(1*i);//moviment quart columna
		}
		return movimientosAlfil;
	}
}

