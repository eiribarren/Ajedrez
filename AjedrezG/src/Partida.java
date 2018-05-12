
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Clase que ejecuta una partida de ajedrez
 * 
 * @author Epumer
 * @author Jan
 * @author Andr&eacute;s
 * @author Eric
 * 
 */
public class Partida {
	static JFrame pantallaPrincipal = new JFrame();
	static Jugador primerJugador;
	static Jugador segundoJugador;
	static Tablero tablero;
	static Jugador jugadorActual;
	static MouseAdapter mousead;
	static JLabel informacionUsuario;
	static JLabel informacionCombate;
	static Casilla[] movimientosEnJaque;
	
	public static void main(String[] args) { 
		prepararInterfazMenu();
		pantallaPrincipal.setVisible(true);
	}
	
	/**
	 * Funci&oacute;n que prepara un tablero agregandole las piezas, define un array de 32 piezas y luego con un for de 8 
	 * iteraciones instanc&iacute;a todas las piezas en su posici&oacute;n a base de sumar valores al &iacute;ndice, luego se recorre 
	 * el array de piezas y se cambia el tama&ntilde;o de estas y finalmente se agregan al tablero.
	 * @param tablero el tablero que se quiere preparar
	 */
	public static void prepararTablero(Tablero tablero) {
		Pieza[] piezas = new Pieza[32];
		for ( int i = 0 ; i < 8 ; i++ ) {
				piezas[i] = new Peon(Color.WHITE, 6, i);
				piezas[i+8] = new Peon(Color.BLACK, 1, i);
				if ( i == 0 || i == 7 ) {
					piezas[i+23] = new Torre(Color.WHITE, 7, i); //23, 30
					piezas[i+24] = new Torre(Color.BLACK, 0, i); //24, 31
				}
				else if (i == 1 || i == 6 ) {
					piezas[i+20] = new Caballo(Color.WHITE, 7, i); //21, 26
					piezas[i+21] = new Caballo(Color.BLACK, 0, i); //22, 27
				}
				else if ( i == 2 || i == 5 ) {
					piezas[i+23] = new Alfil(Color.WHITE, 7, i); //25, 28 
					piezas[i+14] = new Alfil(Color.BLACK, 0, i); //16, 19
				}
				else if (i == 3) {
					piezas[i+17] = new Reina(Color.WHITE, 7, i); //20
					piezas[i+15] = new Reina(Color.BLACK, 0, i); //18
				}
				else if (i == 4) {
					piezas[i+13] = new Rey(Color.WHITE, 7, i); //17
					piezas[i+25] = new Rey(Color.BLACK, 0, i); //29
				}
		}
		for (Pieza pieza : piezas) {
			pieza.cambiarTamano(50, 50);
		}
		tablero.ponerPiezas(piezas);
	}
	
	/**
	 * Funci&oacute;n que prepara la interfaz del menu principal, aqui se define el t&iacute;tulo que se muestra en la aplicaci&oacute;n,
	 * a continuaci&oacute;n se crean dos {@link JPanel}: uno para el menu y el otro para la interfaz, tambi&eacute;n crea cuatro
	 * {@link JLabel}: uno para el t&iacute;tulo, dos para los nombres de los jugadores y el &uacute;ltimo para mostrar errores 
	 * al usuario, seguidamente crea dos {@link JTextField} para introducir los nombres de los jugadores y finalmente
	 * un {@link JButton} para comenzar a jugar.
	 * 
	 * Se realizan ajustes de tama&ntilde;os y alineaci&oacute;n de la interfaz, y se a&ntilde;aden al {@link JPanel} de la interfaz.
	 * 
	 * A continuaci�&oacute;n se a&ntilde;ade un {@link ActionListener} al {@link JButton} de jugar que provoca que al clicar el bot&oacute;n
	 * compruebe si los valores introducidos como nombres de jugador son correctos, en caso de que no lo sean mostrar&aacute;
	 * un error en la {@link JLabel} que creamos para errores y en caso de que todo est&aacute; correcto instanciar&aacute; dos
	 * objetos de la clase {@link Jugador} para el primer y segundo jugador, y asignara al primer jugador como 
	 * jugador actual. Luego se ocultar&aacute; la interfaz del men&uacute; y se instanciar&aacute; el tablero, una vez instanciado a&ntilde;ade
	 * un MouseAdapter a trav&eacute;s de la Funci&oacute;n addMouseListener(MouseListener l) en cada una de las
	 * casillas del tablero, este {@link MouseAdapter} se disparar&aacute; en cuanto cliquemos una casilla y si esta casilla
	 * no esta roja y tiene una pieza, nos mostrar&aacute; las posiciones donde podremos mover esta cambiando el color de las
	 * casillas que se encuentren en dichas posiciones, en cambio si clicamos una casilla de color rojo mover&aacute; la pieza
	 * que ten&iacute;a la casilla previamente seleccionada.
	 * 
	 * Finalmente se muestra informaci&oacute;n de la partida en forma de texto.
	 */
	public static void prepararInterfazMenu() {
		pantallaPrincipal.setTitle("Ajedrez");
		JPanel menu = new JPanel();
		JPanel interfaz = new JPanel();
		JLabel titulo = new JLabel();
		JLabel nombreJugador1_label = new JLabel();
		JLabel nombreJugador2_label = new JLabel();
		JLabel error_label = new JLabel();
		JTextField nombreJugador_textField = new JTextField();
		JTextField nombreJugador2_textField = new JTextField();
		JButton botonJugar = new JButton();
		
		menu.setPreferredSize(new Dimension(500,600));
		menu.setVisible(true);
		
		interfaz.setLayout(new BoxLayout(interfaz, BoxLayout.PAGE_AXIS));
		interfaz.setPreferredSize(new Dimension(300,600));
		interfaz.setAlignmentY(Component.CENTER_ALIGNMENT);
		interfaz.setVisible(true);
		
		nombreJugador_textField.setPreferredSize(new Dimension(200,26));
		nombreJugador_textField.setFont(new Font("Arial", Font.PLAIN, 25));
		nombreJugador_textField.setMaximumSize(new Dimension(200,26));
		nombreJugador_textField.setAlignmentX(Component.CENTER_ALIGNMENT);
		nombreJugador_textField.setVisible(true);

		nombreJugador2_textField.setPreferredSize(new Dimension(200,26));
		nombreJugador2_textField.setFont(new Font("Arial", Font.PLAIN, 25));
		nombreJugador2_textField.setMaximumSize(new Dimension(200,26));
		nombreJugador2_textField.setAlignmentX(Component.CENTER_ALIGNMENT);
		nombreJugador2_textField.setVisible(true);
		
		botonJugar.setText("Jugar");
		botonJugar.setAlignmentX(Component.CENTER_ALIGNMENT);
		botonJugar.setFont(new Font("Arial", Font.PLAIN, 25));
		botonJugar.setVisible(true);
		
		nombreJugador1_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		nombreJugador1_label.setText("Jugador 1: ");
		nombreJugador1_label.setFont(new Font("Arial", Font.PLAIN, 25));

		nombreJugador2_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		nombreJugador2_label.setText("Jugador 2: ");
		nombreJugador2_label.setFont(new Font("Arial", Font.PLAIN, 25));
		
		error_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		error_label.setFont(new Font("Arial", Font.PLAIN, 10));
		error_label.setVisible(true);
		
		titulo.setText("Ajedrez");
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		titulo.setFont(new Font("Arial", Font.PLAIN, 40));
		titulo.setVisible(true);
		
		interfaz.add(titulo);
		interfaz.add(Box.createVerticalStrut(20));
		interfaz.add(nombreJugador1_label);
		interfaz.add(nombreJugador_textField);
		interfaz.add(nombreJugador2_label);
		interfaz.add(nombreJugador2_textField);
		interfaz.add(Box.createVerticalStrut(10));
		interfaz.add(botonJugar);
		interfaz.add(error_label);
		
		botonJugar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String nombre = nombreJugador_textField.getText();
				String nombre2 = nombreJugador2_textField.getText();
				if ( !nombre.equals("") && !nombre2.equals("")) {
					if ( nombre.equals(nombre2) ) {
						error_label.setText("Los nombres de los jugadores deben ser diferentes");
					} else {
						primerJugador = new Jugador( nombre, Color.WHITE);
						segundoJugador = new Jugador( nombre2, Color.BLACK);
						jugadorActual = primerJugador;
						menu.setVisible(false);
						pantallaPrincipal.remove(menu);
						tablero = new Tablero();
						prepararTablero(tablero);
						for ( Casilla[] casillas : tablero.getCasillas()) {
							for ( Casilla casilla : casillas ) {
								casilla.addMouseListener(new MouseAdapter() {
									
									public void mouseClicked(MouseEvent e) {
										
										if ( !casilla.isFocused() ) {
											Pieza pieza = casilla.getPieza();
											if ( pieza != null ) {								
												if ( jugadorActual.getColor() == pieza.getColor()) {
													Casilla.setCasillasRojas(comprobarMovimientos(pieza, tablero.getCasillas()));
												}
											}
										} else {
											Casilla casillaEnFoco = tablero.getCasillaEnFoco();
											Pieza piezaEnFoco = casillaEnFoco.quitarPieza();
											Pieza piezaDestruida = null;
											if ( piezaEnFoco == null ) {
												System.out.print("eh?");
											} else {
												piezaEnFoco.setPosicion(casilla.getFila(), casilla.getColumna());
												piezaDestruida = casilla.ponerPieza(piezaEnFoco);
											
												casillaEnFoco.repaint();
												setText("El jugador " + jugadorActual.toString() + " ha movido el " + piezaEnFoco.toString() + " a la " + casilla.toString(), "informacionUsuario");
												if ( piezaDestruida instanceof Rey ) {
													acabarPartida();
												} else if ( piezaDestruida != null ) {
													setText("La pieza " + piezaEnFoco.toString() + " del jugador " + jugadorActual.toString() + " ha destruido la pieza " + piezaDestruida.toString() + " del rival.", "informacionCombate");
												} else {
													setText("", "informacionCombate");
												}
												if (comprobarJaque(piezaEnFoco)) {
													setText("Jaque!","informacionCombate");
												};
												cambiarJugadorActual();
												for ( Casilla casillaRoja : Casilla.getCasillasRojas() ) {
													if ( casillaRoja != null ) {
														casillaRoja.unfocus();
													}
												}
											}
										}
									}
								});
							}
						}
						JPanel maestro = new JPanel();
						JPanel interfazUsuario = new JPanel();
						JPanel texto = new JPanel();
						BotonRendirse botonRendirse = new BotonRendirse();
						informacionUsuario = new JLabel();
						informacionCombate = new JLabel();
						
						interfazUsuario.setPreferredSize(new Dimension(450,140));
						texto.setPreferredSize(new Dimension(450,50));
						interfazUsuario.add(texto);
						interfazUsuario.add(botonRendirse);
						texto.add(informacionUsuario);
						texto.add(informacionCombate);
						interfazUsuario.setBackground(Color.WHITE);
						texto.setBackground(Color.WHITE);
						interfazUsuario.setVisible(true);
						
						informacionUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
						informacionCombate.setFont(new Font("Arial", Font.PLAIN, 12));
						
						maestro.add(tablero);
						maestro.add(interfazUsuario);
						pantallaPrincipal.add(maestro);
					}
				} else {
					error_label.setText("No se ha introducido el nombre de algún jugador");
				}
			}
			
		}); 
		menu.add(Box.createRigidArea(new Dimension(500,100)));
		menu.add(interfaz);
		pantallaPrincipal.add(menu);
		pantallaPrincipal.pack();
	}
	
	/**
	 * Funci&oacute;n que comprueba los movimientos posibles de las piezas, esto lo hace creando un array de {@link Casilla}
	 * donde guardar&aacute; las casillas donde se puede mover a la pieza seleccionada. A continuaci&oacute;n recorre la m&aacute;triz de
	 * movimientos que puede hacer la pieza y comprueba si algo impide que se realize alguno, como podria ser que esta
	 * en los limites del tablero o que una pieza la bloquea. Si el movimiento pasa todas las comprobaciones se
	 * almacena en un array de {@link Casilla}, el cu&aacute;l finalmente se retorna.
	 * @param pieza la pieza  a la que queremos comprobar los movimientos posibles.
	 * @param casillas los movimientos que puede realizar la pieza.
	 * @return las casillas donde se puede mover la pieza.
	 */
	public static Casilla[] comprobarMovimientos( Pieza pieza, Casilla[][] casillas ) {
		tablero.setCasillaEnFoco( casillas[pieza.getFila()][pieza.getColumna()] );
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
				if ( !(pieza instanceof Caballo ) && !(pieza instanceof Peon ) ) {
					
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
							for ( int j = movimientoY - 1 ; j > pieza.getFila() ; j--) {
								if ( j > 7 || j < 0 ) {
									continue;
								}
								if ( casillas[j][movimientoX].tienePieza() ) {
									bloqueado = true;
									break;
								}								
							}
						} else {
							for ( int j = movimientoY + 1 ; j < pieza.getFila() ; j++) {
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
				if ( movimientosEnJaque != null ) {
					for ( Casilla movimientoEnJaque : movimientosEnJaque ) {
						if ( casillas[movimientoY][movimientoX] == movimientoEnJaque ) {
							Casilla casilla = casillas[movimientoY][movimientoX];
							movimientosPosibles[i] = casilla;
							break;
						}
					}
					continue;
				}
				Casilla casilla = casillas[movimientoY][movimientoX];
				movimientosPosibles[i] = casilla;
			}
		}
		return movimientosPosibles;
	}
	
	/**
	 * Funci&oacute;n que comprueba si el rey se encuentra amenazado y se debe declarar Jaque, esto lo hace recibiendo los
	 * movimientos posibles de una pieza y comprobando si alguno de estos incluye una casilla donde est&aacute; el rey rival.
	 * @param movimientos los movimientos que puede hacer la pieza.
	 * @return true si es jaque y false si no.
	 */
	public static boolean comprobarJaque(Pieza piezaAtacante) {
		Casilla[] movimientos = comprobarMovimientos(piezaAtacante, tablero.getCasillas());
		int contador = 0;
		boolean movimientoEncontrado;
		boolean sePuedeMatar = false;
		for ( Casilla movimiento : movimientos ) {
			movimientoEncontrado = false;
			if ( movimiento != null ) {
				if ( movimiento.getPieza() instanceof Rey ) {
					if ( piezaAtacante.getFila() > movimiento.getPieza().getFila() ) {
						movimientosEnJaque = new Casilla[piezaAtacante.getFila() - movimiento.getPieza().getFila()];
					} else if ( piezaAtacante.getFila() < movimiento.getPieza().getFila() ) {
						movimientosEnJaque = new Casilla[movimiento.getPieza().getFila() - piezaAtacante.getFila()];
					} else {
						if ( piezaAtacante.getColumna() > movimiento.getPieza().getFila() ) {
							movimientosEnJaque = new Casilla[movimiento.getPieza().getColumna() - piezaAtacante.getColumna()];
						} else {
							movimientosEnJaque = new Casilla[movimiento.getPieza().getColumna() - piezaAtacante.getColumna()];
						}
					}
					for ( Casilla[] casillas : tablero.getCasillas() ) {
						if ( movimientoEncontrado ) {
							break;
						}
						for ( Casilla casilla : casillas ) {
							if ( movimientoEncontrado ) {
								break;
							}
							if ( casilla.tienePieza() ) {
								if ( casilla.getPieza().getColor() != piezaAtacante.getColor() ) {
									Casilla[] movimientosProtectores = comprobarMovimientos(casilla.getPieza(), tablero.getCasillas());
									for ( Casilla movimientoProtector : movimientosProtectores ) {
										if ( movimientoProtector == movimiento ) {
											movimientosEnJaque[contador] = movimientoProtector;
											contador++;
											System.out.print(contador);
											movimientoEncontrado = true;
											break;
										} else if ( movimientoProtector == tablero.getCasillas()[piezaAtacante.getFila()][piezaAtacante.getColumna()] && !sePuedeMatar ) {
											sePuedeMatar = true;
											contador++;
											movimientoEncontrado = true;
											break;
										}
									}
								}
							}
						}
					}
					if ( comprobarMate((Rey)movimiento.getPieza()) ) {
						setText("Jaque Mate","informacionCombate");
						acabarPartida();
						return false;
					}
					return true;
				}
			}
		}
		return false;
	}
	
	//TODO: Falta comprobar si alguna ficha del mismo color puede bloquear el ataque o matar al atacante
	public static boolean comprobarMate(Rey rey) {
		Casilla[] movimientos = comprobarMovimientos(rey, tablero.getCasillas());
		Casilla[] movimientosMuerte = new Casilla[movimientos.length];
		Casilla[] movimientosRival;
		boolean jaqueMate = true;
		int contador = 0;
		Color color = rey.getColor();
		if ( movimientosEnJaque.length == 0 ) {
			for ( Casilla[] casillas : tablero.getCasillas() ) {
				for ( Casilla casilla : casillas ) {
					if ( casilla.tienePieza() ) {
						if ( casilla.getPieza().getColor() != color ) {
							movimientosRival = comprobarMovimientos( casilla.getPieza(), tablero.getCasillas() );
							for ( Casilla movimientoRival : movimientosRival ) {
								for ( int i = 0 ; i < movimientos.length ; i++ ) {
									if ( movimientos[i] == null ) {
										continue;
									} else if ( movimientos[i] == movimientoRival ) {
										movimientosMuerte[contador] = movimientos[i];
										movimientos[i] = null;
										contador++;
									}
								}
							}
						}
					}
				}
			}
			for ( Casilla movimiento : movimientos ) {
				if ( movimiento != null ) {
					jaqueMate = false;
				}
			}
		} else {
			jaqueMate = false;
		}
		return jaqueMate;
	}
	
	/**
	 * Funci&oacute;n que acaba la partida quitando todos los MouseListeners que permit&iacute;an jugar y mostrando un
	 * mensaje del ganador.
	 */
	public static void acabarPartida() {
		for ( Casilla[] casillas : tablero.getCasillas() ) {
			for ( Casilla casilla : casillas ) {
			    for( MouseListener al : casilla.getMouseListeners() ) {
			        casilla.removeMouseListener(al);
			    }
			}
		}
		setText("El jugador " + jugadorActual.toString() + " ha ganado", "informacionUsuario");
	}
	
	/**
	 * Funci&oacute;n que cambia el turno de los jugadores
	 */
	public static void cambiarJugadorActual() {
		if ( jugadorActual == primerJugador ) {
			jugadorActual = segundoJugador;
		} else {
			jugadorActual = primerJugador;
		}
	}
	
	/**
	 * Funci&oacute;n que cambia el texto de la interfaz
	 * @param text cadena de texto que se mostrar&aacute; por la interfaz.
	 * @param label cadena de texto para identificar en que sitio se mostrar&aacute; el texto.
	 */
	public static void setText(String text, String label) {
		if ( label.equals("informacionUsuario")) {
			informacionUsuario.setText(text);
		} else if ( label.equals("informacionCombate") ) {
			informacionCombate.setText(text);
		}
	}
}