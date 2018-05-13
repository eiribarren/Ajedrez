
import java.awt.Color;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
/**
 * Clase que define a un tablero 8x8 para utilizar en juegos que requieran de este
 * @author Epumer
 *
 */
public class Tablero extends JPanel{
	/**
	 * Constante COLUMNAS nos indica el n&uacute;mero de columnas del tablero.
	 */
	private final int COLUMNAS = 8;
	
	/**
	 * Constante FILAS nos indica el n&uacute;mero de filas del tablero.
	 */
	private final int FILAS = 8;
	
	/**
	 * m&aacute;triz casillas donde se guardar&aacute;n las casillas.
	 */
	private Casilla[][] casillas = new Casilla[FILAS][COLUMNAS];
	
	/**
	 * Casilla casillaEnFoco es la casilla seleccionada actualmente.
	 */
	private Casilla casillaEnFoco;
	private int alto;
	private int ancho;
	
	/**
	 * Constructor del tablero.
	 * 
	 * @param ancho ancho del tablero
	 * @param alto alto del tablero
	 */
	public Tablero(int ancho, int alto) {
		prepararInterfaz(ancho, alto);
		setVisible(true);			
	}
	
	/**
	 * Funci&oacute;n que prepara la interfaz del tablero.
	 * Primero crea un {@link JPanel} al que se le aplica un layout de tipo {@link GridLayout} y a continuaci�n 
	 * instanc�a las casillas y las guarda en la m&aacute;triz casillas, luego a&ntilde;ade las casillas en el {@link JPanel} tablero 
	 * y finalmente a&ntilde;ade este al propio tablero.
	 * @param ancho ancho del tablero
	 * @param alto alto del tablero
	 */
	public void prepararInterfaz(int ancho, int alto) {
		JPanel tablero = new JPanel();
		tablero.setVisible(true);
		tablero.setLayout(new GridLayout(8,8));
		for ( int i = 0 ; i < FILAS ; i++ ) {
			for ( int j = 0 ; j < COLUMNAS ; j++ ) {
				if ( i % 2 == 0 ) {
					if ( j % 2 == 0 ) {
						casillas[i][j] = new Casilla(Color.GRAY, i, j, ancho/8, alto/8);
					} else {
						casillas[i][j] = new Casilla(Color.WHITE, i, j, ancho/8, alto/8);
					}
				} else {
					if ( j % 2 != 0 ) {
						casillas[i][j] = new Casilla(Color.GRAY, i, j, ancho/8, alto/8);
					} else {
						casillas[i][j] = new Casilla(Color.WHITE, i, j, ancho/8, alto/8);
					}					
				}
			}
		}
		for ( Casilla[] casilla1 : casillas ) {
			for ( Casilla casilla : casilla1 ) {
				tablero.add(casilla);
			}
		}
		
		add(tablero);
	}
	
	/**
	 * Funci&oacute;n que selecciona una casilla, si hay casillas seleccionadas (rojas) las deselecciona.
	 * @param casilla la casilla a seleccionar.
	 */
	public void setCasillaEnFoco(Casilla casilla) {
		if ( Casilla.getCasillasRojas() != null ) {
			for ( Casilla casillaRoja : Casilla.getCasillasRojas() ) {
				if ( casillaRoja != null ) {
					casillaRoja.unfocus();
				}
			}
		}
		this.casillaEnFoco = casilla;
	}
	
	/**
	 * Funci&oacute;n que retorna la casilla seleccionada.
	 * @return la casilla seleccionada.
	 */
	public Casilla getCasillaEnFoco() {
		return this.casillaEnFoco;
	}
	
	/**
	 * Funci&oacute;n que retorna la m&aacute;triz de casillas del tablero.
	 * @return las casillas del tablero.
	 */
	public Casilla[][] getCasillas() {
		return this.casillas;
	}
	
	/**
	 * Funci&oacute;n para agregar piezas al tablero.
	 * @param piezas Las piezas a agregar al tablero.
	 */
	public void ponerPiezas(Pieza[] piezas) {
		for ( Pieza pieza : piezas ) {
				casillas[pieza.getFila()][pieza.getColumna()].ponerPieza(pieza);
		}
		this.repaint();
	}
	
}
