import java.awt.Dimension;
import java.awt.Color;

/**
 * 
 * @author Eric
 *
 */

public class Torre extends Pieza{
	public boolean torreUsada;
	

	public Torre(Color color, int fila, int columna) {
		this.torreUsada = false;
		this.columna = columna;
		this.fila = fila;
		this.identificador = "Torre";
		this.color = color;
		this.setVisible(true);
		if ( color == Color.BLACK ) {
			this.urlImagen = "/TorreNegra.png";
		} else {
			this.urlImagen = "/TorreBlanca.png";
		}
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlImagen)));
		this.setPreferredSize(new Dimension(50,50));
		start();
	}

	public boolean seMovio() {
		return torreUsada;
	}

	public void setTorreUsada(boolean torreUsada) {
		this.torreUsada = torreUsada;
	}

	/**
	 * Este metodo primero crea una matriz para guardar los movimientos y a continuaci&oacute;n el primer bucle for 
	 * comprueba los movimientos horizontales y verticales en direcci&oacute;n sur, el segundo al norte, el tercero 
	 * hacia el oeste y el cuarto al este.
	 * 
	 * @return moviments Los movimientos que puede hacer la torre.
	 */
	public int[][] getMovimientos(){
		int[][] moviments = new int[28][2];


		for(int i=1;i<8;i++){
			moviments[i-1][0] = getFila()+(1*i);
			moviments[i-1][1] = getColumna();
		}

		for(int i=1;i<8;i++){
			moviments[i+6][0] = getFila()-(1*i);
			moviments[i+6][1] = getColumna();
		}

		for(int i=1;i<8;i++){
			moviments[i+13][0] = getFila();
			moviments[i+13][1] = getColumna()-(1*i);
		}

		for(int i=1;i<8;i++){
			moviments[i+20][0] = getFila();
			moviments[i+20][1] = getColumna()+(1*i);
		}
		return moviments;
	}
}
