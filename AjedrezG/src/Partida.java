
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
		
		menu.setPreferredSize(new Dimension(1000,1000));
		menu.setVisible(true);
		
		interfaz.setLayout(new BoxLayout(interfaz, BoxLayout.PAGE_AXIS));
		interfaz.setPreferredSize(new Dimension(600,1000));
		interfaz.setAlignmentY(Component.CENTER_ALIGNMENT);
		interfaz.setVisible(true);
		
		nombreJugador_textField.setPreferredSize(new Dimension(400,54));
		nombreJugador_textField.setFont(new Font("Arial", Font.PLAIN, 50));
		nombreJugador_textField.setMaximumSize(new Dimension(400,54));
		nombreJugador_textField.setAlignmentX(Component.CENTER_ALIGNMENT);
		nombreJugador_textField.setVisible(true);

		nombreJugador2_textField.setPreferredSize(new Dimension(400,54));
		nombreJugador2_textField.setFont(new Font("Arial", Font.PLAIN, 50));
		nombreJugador2_textField.setMaximumSize(new Dimension(400,54));
		nombreJugador2_textField.setAlignmentX(Component.CENTER_ALIGNMENT);
		nombreJugador2_textField.setVisible(true);
		
		botonJugar.setText("Jugar");
		botonJugar.setAlignmentX(Component.CENTER_ALIGNMENT);
		botonJugar.setFont(new Font("Arial", Font.PLAIN, 50));
		botonJugar.setVisible(true);
		
		nombreJugador1_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		nombreJugador1_label.setText("Jugador 1: ");
		nombreJugador1_label.setFont(new Font("Arial", Font.PLAIN, 50));

		nombreJugador2_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		nombreJugador2_label.setText("Jugador 2: ");
		nombreJugador2_label.setFont(new Font("Arial", Font.PLAIN, 50));
		
		error_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		error_label.setFont(new Font("Arial", Font.PLAIN, 20));
		error_label.setVisible(true);
		
		titulo.setText("Ajedrez");
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		titulo.setFont(new Font("Arial", Font.PLAIN, 80));
		titulo.setVisible(true);
		
		interfaz.add(titulo);
		interfaz.add(Box.createVerticalStrut(40));
		interfaz.add(nombreJugador1_label);
		interfaz.add(nombreJugador_textField);
		interfaz.add(nombreJugador2_label);
		interfaz.add(nombreJugador2_textField);
		interfaz.add(Box.createVerticalStrut(20));
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
						pantallaPrincipal.add(tablero);
					}
				} else {
					error_label.setText("No se ha introducido el nombre de algún jugador");
				}
			}
			
		}); 
		menu.add(Box.createRigidArea(new Dimension(1000,200)));
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
