package Juego;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class Tablero extends JFrame{
	private final int COLUMNAS = 8;
	private final int FILAS = 8;
	private Casilla[][] casillas = new Casilla[FILAS][COLUMNAS];
	
	public Tablero() {
		super("Ajedrez");
		start();		
	}
	
	public void start() {
		prepararInterfaz();
		setVisible(true);
		
	}
	
	public void prepararInterfaz() {
		JPanel maestro = new JPanel();
		maestro.setLayout(new GridLayout(8,8));
		for ( int i = 0 ; i < FILAS ; i++ ) {
			for ( int j = 0 ; j < COLUMNAS ; j++ ) {
				if ( i % 2 == 0 ) {
					if ( j % 2 == 0 ) {
						casillas[i][j] = new Casilla(Color.GRAY);
					} else {
						casillas[i][j] = new Casilla(Color.WHITE);
					}
				} else {
					if ( j % 2 != 0 ) {
						casillas[i][j] = new Casilla(Color.GRAY);
					} else {
						casillas[i][j] = new Casilla(Color.WHITE);
					}					
				}
			}
		}
		for ( Casilla[] casilla1 : casillas ) {
			for ( Casilla casilla : casilla1 ) {
				maestro.add(casilla);
			}
		}
		
		for ( int i = 0 ; i < COLUMNAS ; i++ ) {
			switch(i) {
				case 0:
					casillas[7][i].add( new Torre(Color.WHITE) );
					casillas[0][i].add( new Torre(Color.BLACK) );
					break;
					
				case 1:
					casillas[7][i].add( new Caballo(Color.WHITE) );
					casillas[0][i].add( new Caballo(Color.BLACK) );
					break;
					
				case 2:
					casillas[7][i].add( new Alfil(Color.WHITE) );
					casillas[0][i].add( new Alfil(Color.BLACK) );
					break;
					
				case 3:
					casillas[7][i].add( new Reina(Color.WHITE) );
					casillas[0][i].add( new Reina(Color.BLACK) );
					break;
					
				case 4:
					casillas[7][i].add( new Rey(Color.WHITE) );
					casillas[0][i].add( new Rey(Color.BLACK) );
					break;
					
				case 5:
					casillas[7][i].add( new Alfil(Color.WHITE) );
					casillas[0][i].add( new Alfil(Color.BLACK) );
					break;
					
				case 6:
					casillas[7][i].add( new Caballo(Color.WHITE) );
					casillas[0][i].add( new Caballo(Color.BLACK) );
					break;
					
				case 7:
					casillas[7][i].add( new Torre(Color.WHITE) );
					casillas[0][i].add( new Torre(Color.BLACK) );
					break;
			}
			casillas[1][i].add(new Peon(Color.BLACK) );
			casillas[6][i].add(new Peon(Color.WHITE) );
			
		}
		add(maestro);
		
		pack();
	}
	
}
