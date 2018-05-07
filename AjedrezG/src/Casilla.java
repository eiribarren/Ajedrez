
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.*;

public class Casilla extends JPanel{
	private final int DEFAULT_WIDTH = 50;
	private final int DEFAULT_HEIGHT = 50;
	private static Casilla[] casillasRojas;
	private int columna;
	private int fila;
	private Pieza pieza;
	private Color color;
	
	public Casilla(Color color, int fila, int columna) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.color = color;
		this.setBackground(color);
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
		this.setMaximumSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
		this.setVisible(true);
	}
	
	public void focus(Pieza pieza, Casilla[] movimientosPosibles) {
		Casilla.casillasRojas = movimientosPosibles;
		this.setBackground(color.RED);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	public void unfocus() {
		this.setBackground(color);
		this.setCursor(Cursor.getDefaultCursor());
		this.repaint();
	}
	
	public String ponerPieza( Pieza pieza ) {
		String nombrePiezaDestruida = "";
		if ( this.tienePieza() ) {
			nombrePiezaDestruida = this.pieza.toString();
			this.remove(this.pieza);
		}
		this.pieza = pieza;
		this.add(pieza);
		return nombrePiezaDestruida;
	}
	
	public Pieza quitarPieza() {
		Pieza piezaQuitada = this.pieza;
		this.pieza = null;
		return piezaQuitada;
	}
	
	public boolean tienePieza() {
		if ( this.pieza != null ) {
			return true;
		} else {
			return false;
		}
	}
	
	public Pieza getPieza() {
		return this.pieza;
	}
	
	public int getColumna() {
		return this.columna;
	}
	
	public int getFila() {
		return this.fila;
	}
	
	public static Casilla[] getCasillasRojas() {
		return casillasRojas;
	}
	
	public String toString() {
		String frase = "Casilla " + getFila() + ":" + getColumna();
		return frase;
	}
	
	public Casilla yoMismo() {
		return this;
	}
}
