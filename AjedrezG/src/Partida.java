
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Partida {
	static JFrame pantallaPrincipal = new JFrame();
	static Jugador primerJugador;
	static Jugador segundoJugador;
	static Tablero tablero;
	
	public static void main(String[] args) {
	   prepararInterfazMenu();
	   pantallaPrincipal.setVisible(true);
	   
	}
	
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
	
	public static void prepararInterfazMenu() {
		pantallaPrincipal.setTitle("Ajedrez");
		JPanel menu = new JPanel();
		JPanel interfaz = new JPanel();
		JLabel titulo = new JLabel();
		JTextField nombreJugador_textField = new JTextField();
		JTextField nombreJugador2_textField = new JTextField();
		JLabel nombreJugador1_label = new JLabel();
		JLabel nombreJugador2_label = new JLabel();
		JLabel error_label = new JLabel();
		JButton botonJugar = new JButton();
		
		menu.setPreferredSize(new Dimension(500,500));
		menu.setVisible(true);
		
		interfaz.setLayout(new BoxLayout(interfaz, BoxLayout.PAGE_AXIS));
		interfaz.setPreferredSize(new Dimension(300,500));
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
						menu.setVisible(false);
						pantallaPrincipal.remove(menu);
						tablero = new Tablero(primerJugador, segundoJugador);
						prepararTablero(tablero);
						pantallaPrincipal.add(tablero);
					}
				} else {
					error_label.setText("No se ha introducido el nombre de alg�n jugador");
				}
			}
			
		}); 
		menu.add(Box.createRigidArea(new Dimension(500,100)));
		menu.add(interfaz);
		pantallaPrincipal.add(menu);
		pantallaPrincipal.pack();
	}
	
	public static Tablero getTablero() {
		return tablero;
	}
	
	public static Jugador getJugador( Color color ) {
		if ( color == Color.WHITE ) {
			return primerJugador;
		} else {
			return segundoJugador;
		}
	}
}
