import java.awt.Dimension;
import java.awt.Color;
/**
 * 
 * @author Eric
 *
 */
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

	/**
	 * Este metodo primero crea una matriz para guardar los movimientos y a continuaci&oacute;n el primer bucle for 
	 * comprueba los movimientos diagonales en direcci&oacute;n sureste, el segundo al suroeste, el tercero noreste
	 * y el cuarto al noroeste.
	 * A partir del quinto for, los movimientos son horizontales y verticales. El quinto comprueba los movimientos 
	 * hacia el sur, el sexto hacia el norte, el septimo hacia el oeste y el septimo, y ultimo, hacia el este.
	 * 
	 * @return moviments Los movimientos que puede hacer la reina.
	 */
	public int[][] getMovimientos(){
		int[][] moviments = new int[56][2];

		for(int i=1;i<8;i++){
			moviments[i-1][0] = getFila()+(1*i);
			moviments[i-1][1] = getColumna()+(1*i);
		}
		for(int i=1;i<8;i++){
			moviments[i+6][0] = getFila()+(1*i);
			moviments[i+6][1] = getColumna()-(1*i);
		}
		for(int i=1;i<8;i++){
			moviments[i+13][0] = getFila()-(1*i);
			moviments[i+13][1] = getColumna()+(1*i);
		}
		for(int i=1;i<8;i++){
			moviments[i+20][0] = getFila()-(1*i);
			moviments[i+20][1] = getColumna()-(1*i);
		}



		for(int i=1;i<8;i++){
			moviments[i+27][0] = getFila()+(1*i);
			moviments[i+27][1] = getColumna();
		}

		for(int i=1;i<8;i++){
			moviments[i+34][0] = getFila()-(1*i);
			moviments[i+34][1] = getColumna();
		}

		for(int i=1;i<8;i++){
			moviments[i+41][0] = getFila();
			moviments[i+41][1] = getColumna()-(1*i);
		}

		for(int i=1;i<8;i++){
			moviments[i+48][0] = getFila();
			moviments[i+48][1] = getColumna()+(1*i);
		}


		return moviments;
	}
}
