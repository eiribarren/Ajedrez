import java.awt.Dimension;
import java.awt.Color;

public class Reina extends Pieza{
	public Reina(Color color, int fila, int columna) {
		this.columna = columna;
		this.fila = fila;
		this.identificador = "Reina";
		this.color = color;
		this.setVisible(true);
		if ( color == Color.BLACK ) {
			this.urlImagen = "/ReinaNegra.png";
		} else {
			this.urlImagen = "/ReinaBlanca.png";
		}
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlImagen)));
		this.setPreferredSize(new Dimension(50,50));
		start();
	}
	
	
    public int[][] getMovimientos(){
   	 int[][] movimientos = new int[56][2];
   	 
   	 // moviments alfil
   	 for(int i=1;i<8;i++){
   		 movimientos[i-1][0] = getFila()+(1*i);
   		 movimientos[i-1][1] = getColumna()+(1*i);
   	 }
   	 for(int i=1;i<8;i++){
   		 movimientos[i+6][0] = getFila()-(1*i);
   		 movimientos[i+6][1] = getColumna()+(1*i);
   	 }
   	 for(int i=1;i<8;i++){
   		 movimientos[i+13][0] = getFila()+(1*i);
   		 movimientos[i+13][1] = getColumna()-(1*i);
   	 }
   	 for(int i=1;i<8;i++){
   		 movimientos[i+20][0] = getFila()-(1*i);
   		 movimientos[i+20][1] = getColumna()-(1*i);
   	 }

 	
   // moviments torre
   	 for(int i=1;i<8;i++){
   		 movimientos[i+27][0] = getFila()+(1*i);
   		 movimientos[i+27][1] = getColumna();
   	 }
   	 
   	 for(int i=1;i<8;i++){
   		 movimientos[i+34][0] = getFila()-(1*i);
   		 movimientos[i+34][1] = getColumna();
   	 }
   	 
   	 for(int i=1;i<8;i++){
   		 movimientos[i+41][0] = getFila();
   		 movimientos[i+41][1] = getColumna()-(1*i);
   	 }
   	 
   	 for(int i=1;i<8;i++){
   		 movimientos[i+48][0] = getFila();
   		 movimientos[i+48][1] = getColumna()+(1*i);
   	 }
	
 
   	 return movimientos;
    }
}
