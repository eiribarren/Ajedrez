
import java.awt.Color;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class Tablero extends JPanel{
	private final int COLUMNAS = 8;
	private final int FILAS = 8;
	private Casilla[][] casillas = new Casilla[FILAS][COLUMNAS];
	private Casilla casillaEnFoco;
	
	public Tablero() {
		start();		
	}
	
	public void start() {
		prepararInterfaz();
		setVisible(true);	
	}
	
	public void prepararInterfaz() {
		JPanel tablero = new JPanel();
		tablero.setVisible(true);
		tablero.setLayout(new GridLayout(8,8));
		for ( int i = 0 ; i < FILAS ; i++ ) {
			for ( int j = 0 ; j < COLUMNAS ; j++ ) {
				if ( i % 2 == 0 ) {
					if ( j % 2 == 0 ) {
						casillas[i][j] = new Casilla(Color.GRAY, i, j);
					} else {
						casillas[i][j] = new Casilla(Color.WHITE, i, j);
					}
				} else {
					if ( j % 2 != 0 ) {
						casillas[i][j] = new Casilla(Color.GRAY, i, j);
					} else {
						casillas[i][j] = new Casilla(Color.WHITE, i, j);
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
	
	public Casilla getCasillaEnFoco() {
		return this.casillaEnFoco;
	}
	
	public Casilla[][] getCasillas() {
		return this.casillas;
	}
	
	public void ponerPiezas(Pieza[] piezas) {
		for ( Pieza pieza : piezas ) {
				casillas[pieza.getFila()][pieza.getColumna()].ponerPieza(pieza);
		}
		this.repaint();
	}
	
}
