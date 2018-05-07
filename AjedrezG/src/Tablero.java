
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
	private int turno = 0;
	private Jugador primerJugador;
	private Jugador segundoJugador;
	private Jugador jugadorActual;
	private Casilla casillaEnFoco;
	private JLabel informacionUsuario;
	private JLabel informacionCombate;
	
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
		JPanel texto = new JPanel();
		BotonRendirse botonRendirse = new BotonRendirse();
		informacionUsuario = new JLabel();
		informacionCombate = new JLabel();
		
		informacionUsuario.setFont(new Font("Arial", Font.PLAIN, 23));
		informacionCombate.setFont(new Font("Arial", Font.PLAIN, 23));
		
		maestro.setPreferredSize(new Dimension(500,500));
		interfazUsuario.setPreferredSize(new Dimension(450,90));
		texto.setPreferredSize(new Dimension(450,50));
		interfazUsuario.add(texto);
		interfazUsuario.add(botonRendirse);
		texto.add(informacionUsuario);
		texto.add(informacionCombate);
		interfazUsuario.setBackground(Color.WHITE);
		texto.setBackground(Color.WHITE);
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
					casillas[7][i].ponerPieza( new Caballo(Color.WHITE, 7, i ) );
					casillas[0][i].ponerPieza( new Caballo(Color.BLACK, 0, i) );
					break;
					
				case 2:
					casillas[7][i].ponerPieza( new Alfil(Color.WHITE, 7, i) );
					casillas[0][i].ponerPieza( new Alfil(Color.BLACK, 0, i) );
					break;
					
				case 3:
					casillas[7][i].ponerPieza( new Reina(Color.WHITE) );
					casillas[0][i].ponerPieza( new Reina(Color.BLACK) );
					break;
					
				case 4:
					casillas[7][i].ponerPieza( new Rey(Color.WHITE,7,i) );
					casillas[0][i].ponerPieza( new Rey(Color.BLACK,0,i) );
					break;
					
				case 5:
					casillas[7][i].ponerPieza( new Alfil(Color.WHITE, 7, i) );
					casillas[0][i].ponerPieza( new Alfil(Color.BLACK, 0, i) );
					break;
					
				case 6:
					casillas[7][i].ponerPieza( new Caballo(Color.WHITE, 7, i) );
					casillas[0][i].ponerPieza( new Caballo(Color.BLACK, 0, i) );
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
		this.casillaEnFoco = casillas[pieza.getFila()][pieza.getColumna()];
		int[][] movimientos = pieza.getMovimientos();
		Casilla[] movimientosPosibles = new Casilla[movimientos.length];
		int movimientoX;
		int movimientoY;
		for ( int i = 0 ; i < movimientos.length ; i++ ) {
			movimientoY = movimientos[i][0];
			movimientoX = movimientos[i][1];
			boolean bloqueado = false;
			if ( movimientoX > 7 || movimientoX < 0 || movimientoY > 7 || movimientoY < 0 ) {
				continue;
			} else {
				if ( !(pieza instanceof Caballo ) && !(pieza instanceof Peon )) {
					
					// Diagonal \
					if ( pieza.getFila() < movimientoY && pieza.getColumna() < movimientoX ) {
						for ( int j = 1 ; j < movimientoY - pieza.getFila() ; j++ ) {
							if ( pieza.getFila() + j > 7 || pieza.getColumna() + j > 7 ) {
								continue;
							}
							if ( casillas[pieza.getFila() + j][pieza.getColumna() + j].tienePieza() ) {
								bloqueado = true;
								break;
							}
						}
					} else if ( pieza.getFila() > movimientoY && pieza.getColumna() > movimientoX ) {
						for ( int j = 1 ; j < pieza.getFila() - movimientoY ; j++ ) {
							if ( pieza.getFila() - j < 0 || pieza.getColumna() - j < 0) {
								continue;
							}
							if ( casillas[pieza.getFila() - j][pieza.getColumna() - j].tienePieza() ) {
								bloqueado = true;
								break;
							}
						}
					//Diagonal /
					} else if ( pieza.getFila() < movimientoY && pieza.getColumna() > movimientoX ) {
						for ( int j = 1 ; j < movimientoY - pieza.getFila() ; j++ ) {
							//7:2 4:5
							if ( pieza.getFila() + j > 7 || pieza.getColumna() - j < 0 ) {
								continue;
							}
							if ( casillas[pieza.getFila() + j][pieza.getColumna() - j].tienePieza() ) {
								bloqueado = true;
								break;
							}
						}						
					} else if ( pieza.getFila() > movimientoY && pieza.getColumna() < movimientoX ) {
						for ( int j = 1 ; j < pieza.getFila() - movimientoY ; j++ ) {
							if ( pieza.getFila() - j < 0 || pieza.getColumna() + j > 7 ) {
								continue;
							}
							if ( casillas[pieza.getFila() - j][pieza.getColumna() + j].tienePieza() ) {
								bloqueado = true;
								break;
							}
						}
					//Movimiento horizontal ---
					} else if ( pieza.getFila() == movimientoY ) {
						if ( pieza.getColumna() < movimientoX) {
							for ( int j = movimientoX - 1 ; j > pieza.getColumna() ; j--) {
								if ( j > 7 || j < 0 ) {
									continue;
								}
								if ( casillas[movimientoY][j].tienePieza() ) {
									bloqueado = true;
									break;
								}								
							}
						} else {
							for ( int j = movimientoX + 1; j < pieza.getColumna() ; j++) {
								if ( j > 7 || j < 0 ) {
									continue;
								}
								if ( casillas[movimientoY][j].tienePieza() ) {
									bloqueado = true;
									break;
								}								
							}
						}
					//Movimiento vertical |
					} else if ( pieza.getColumna() == movimientoX) {
						if ( pieza.getFila() < movimientoY) {
							for ( int j = movimientoY + 1 ; j > pieza.getFila() ; j--) {
								if ( j > 7 || j < 0 ) {
									continue;
								}
								if ( casillas[j][movimientoX].tienePieza() ) {
									bloqueado = true;
									break;
								}								
							}
						} else {
							for ( int j = movimientoY - 1 ; j > pieza.getFila() ; j++) {
								if ( j > 7 || j < 0 ) {
									continue;
								}
								if ( casillas[j][movimientoX].tienePieza() ) {
									bloqueado = true;
									break;
								}								
							}
						}
					}
					if ( bloqueado ) {
						continue;
					}
				}
				if ( casillas[movimientoY][movimientoX].tienePieza()) {
					if ( pieza.getColor() == casillas[movimientoY][movimientoX].getPieza().getColor() ) {
						continue;
					}
				}
				if ( pieza instanceof Peon ) {
					if ( movimientoX != pieza.getColumna() + 1  && movimientoX != pieza.getColumna() - 1 ) {
						if ( casillas[movimientoY][movimientoX].tienePieza() ) {
							continue;
						}
					} else if ( !casillas[movimientoY][movimientoX].tienePieza()) {
						continue;
					}
				}
				movimientosPosibles[i] = casillas[movimientoY][movimientoX];
				casillas[movimientoY][movimientoX].focus(pieza, movimientosPosibles);
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
	
	public void setText(String text, String label) {
		if ( label.equals("informacionUsuario")) {
			this.informacionUsuario.setText(text);
		} else if ( label.equals("informacionCombate") ) {
			this.informacionCombate.setText(text);
		}
	}
}
