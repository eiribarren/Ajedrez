
import java.awt.Dimension;
import java.awt.Color;

public class Torre extends Pieza{
	public Torre(Color color, int fila, int columna) {
		this.identificador = "Torre";
		this.columna = columna;
		this.fila = fila;
		this.color = color;
		this.setVisible(true);
		if ( color == Color.BLACK ) {
			this.urlImagen = "/TorreNegra.png";
		} else {
			this.urlImagen = "/TorreBlanca.png";
		}
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlImagen)));
		this.setPreferredSize(new Dimension(100,100));
		start();
	}
	public int[][] getMovimientos(){
		int[][] movimientos = new int[28][2];
		 
		
		for(int i=1;i<8;i++){
	   		 movimientos[i-1][0] = getFila()+(1*i);
	   		 movimientos[i-1][1] = getColumna();
	   	 }
	   	 
	   	 for(int i=1;i<8;i++){
	   		 movimientos[i+6][0] = getFila()-(1*i);
	   		 movimientos[i+6][1] = getColumna();
	   	 }
	   	 
	   	 for(int i=1;i<8;i++){
	   		 movimientos[i+13][0] = getFila();
	   		 movimientos[i+13][1] = getColumna()-(1*i);
	   	 }
	   	 
	   	 for(int i=1;i<8;i++){
	   		 movimientos[i+20][0] = getFila();
	   		 movimientos[i+20][1] = getColumna()+(1*i);
	   	 }
		return movimientos;
	}
}
