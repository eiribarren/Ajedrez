package Juego;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;

public class Tablero extends JPanel{
	private final int COLUMNAS = 8;
	private final int FILAS = 8;
	private Casilla[][] casillas = new Casilla[FILAS][COLUMNAS];
	private int turno = 0;
	private Jugador primerJugador;
	private Jugador segundoJugador;
	private Jugador jugadorActual;
	private Casilla casillaEnFoco;
	
	public Tablero(Jugador primerJugador, Jugador segundoJugador) {
		this.primerJugador = primerJugador;
		this.segundoJugador = segundoJugador;
		this.jugadorActual = primerJugador;
		start();		
	}
	
	public void start() {
		prepararInterfaz();
		setVisible(true);	
	}
	
	public void prepararInterfaz() {
		JPanel maestro = new JPanel();
		JPanel tablero = new JPanel();
		JPanel interfazUsuario = new JPanel();
		
		maestro.setPreferredSize(new Dimension(1000,1000));
		interfazUsuario.setPreferredSize(new Dimension(900,180));
		interfazUsuario.setBackground(Color.WHITE);
		interfazUsuario.setVisible(true);
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
		
		for ( int i = 0 ; i < COLUMNAS ; i++ ) {
			switch(i) {
				case 0:
					casillas[7][i].ponerPieza( new Torre(Color.WHITE) );
					casillas[0][i].ponerPieza( new Torre(Color.BLACK) );
					break;
					
				case 1:
					casillas[7][i].ponerPieza( new Caballo(Color.WHITE) );
					casillas[0][i].ponerPieza( new Caballo(Color.BLACK) );
					break;
					
				case 2:
					casillas[7][i].ponerPieza( new Alfil(Color.WHITE) );
					casillas[0][i].ponerPieza( new Alfil(Color.BLACK) );
					break;
					
				case 3:
					casillas[7][i].ponerPieza( new Reina(Color.WHITE) );
					casillas[0][i].ponerPieza( new Reina(Color.BLACK) );
					break;
					
				case 4:
					casillas[7][i].ponerPieza( new Rey(Color.WHITE) );
					casillas[0][i].ponerPieza( new Rey(Color.BLACK) );
					break;
					
				case 5:
					casillas[7][i].ponerPieza( new Alfil(Color.WHITE) );
					casillas[0][i].ponerPieza( new Alfil(Color.BLACK) );
					break;
					
				case 6:
					casillas[7][i].ponerPieza( new Caballo(Color.WHITE) );
					casillas[0][i].ponerPieza( new Caballo(Color.BLACK) );
					break;
					
				case 7:
					casillas[7][i].ponerPieza( new Torre(Color.WHITE) );
					casillas[0][i].ponerPieza( new Torre(Color.BLACK) );
					break;
			}
			casillas[1][i].ponerPieza(new Peon(Color.BLACK, 1, i ) );
			casillas[6][i].ponerPieza(new Peon(Color.WHITE, 6, i ));
			
		}
		maestro.add(tablero);
		maestro.add(interfazUsuario);
		add(maestro);
	}
	
	public void comprobarMovimientos( Pieza pieza ) {
		this.casillaEnFoco = casillas[pieza.posicionY][pieza.posicionX];
		int[][] movimientos = pieza.getMovimientos();
		Casilla[] casillasConFoco = new Casilla[movimientos.length];
		int movimientoX;
		int movimientoY;
		for ( int i = 0 ; i < movimientos.length ; i++ ) {
			movimientoX = movimientos[i][0];
			movimientoY = movimientos[i][1];
			if ( movimientoX > 7 || movimientoX < 0 || movimientoY > 7 || movimientoY < 0 ) {
				continue;
			} else {
				System.out.println(casillas[movimientoX][movimientoY]);
				casillasConFoco[i] = casillas[movimientoX][movimientoY];
				casillas[movimientoX][movimientoY].focus(pieza, casillasConFoco);
			}
		}
		
	}
	
	public Casilla getCasillaEnFoco() {
		return this.casillaEnFoco;
	}
	
	public void setJugadorActual() {
		if ( this.jugadorActual == primerJugador ) {
			this.jugadorActual = segundoJugador;
		} else {
			this.jugadorActual = primerJugador;
		}
	}
	
	public Jugador getJugadorActual() {
		return jugadorActual;
	}
}
