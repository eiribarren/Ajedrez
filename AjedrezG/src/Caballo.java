
import java.awt.Dimension;
import java.awt.Color;
/**
 * 
 * @author Andres
 *
 */
public class Caballo extends Pieza{
	public Caballo(Color color, int fila, int columna) {
		this.columna = columna;
		this.fila = fila;
		this.identificador = "Caballo";
		this.color = color;
		this.setVisible(true);
		if ( color == Color.BLACK ) {
			this.urlImagen = "/CaballoNegro.png";
		} else {
			this.urlImagen = "/CaballoBlanco.png";
		}
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlImagen)));
		this.setPreferredSize(new Dimension(50,50));
		start();
	}
	//Columna=X Fila=Y
	public int[][] getMovimientos(){
		int[][] movimientosCaballo = new int[8][2];
			movimientosCaballo[0][0]=getFila()+2;//moviment primer fila
			movimientosCaballo[0][1]=getColumna()+1;//moviment primer columna
			
			movimientosCaballo[1][0]=getFila()+2; //moviment segon fila
			movimientosCaballo[1][1]=getColumna()-1; //moviment segon columna
			
			movimientosCaballo[2][0]=getFila()+1;//moviment tercer fila
			movimientosCaballo[2][1]=getColumna()+2;//moviment tercer columna
			
			movimientosCaballo[3][0]=getFila()-1; //moviment quart fila
			movimientosCaballo[3][1]=getColumna()+2; //moviment quart columna
			
			movimientosCaballo[4][0]=getFila()-2;//moviment cinque fila
			movimientosCaballo[4][1]=getColumna()-1;//moviment cinque columna
			
			movimientosCaballo[5][0]=getFila()-2; //moviment sise fila
			movimientosCaballo[5][1]=getColumna()+1; //moviment sise columna
			
			movimientosCaballo[6][0]=getFila()-1; //moviment sete fila
			movimientosCaballo[6][1]=getColumna()-2; //moviment sete columna
			
			movimientosCaballo[7][0]=getFila()+1; //moviment vuite fila
			movimientosCaballo[7][1]=getColumna()-2; //moviment vuite columna
			return movimientosCaballo;
	}
}

