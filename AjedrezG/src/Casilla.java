
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.*;
/**
 * Clase {@link Casilla} que se puede utilizar para construir un tablero.
 * @author Epumer
 *
 */
public class Casilla extends JPanel{
	private final int DEFAULT_WIDTH = 50;
	private final int DEFAULT_HEIGHT = 50;
	private static Casilla[] casillasRojas;
	private int columna;
	private int fila;
	private Pieza pieza;
	private Color color;
	private boolean focused = false;
	
	/**
	 * Constructor de casilla
	 * @param color color de la casilla.
	 * @param fila posici&oacute;n vertical de la casilla.
	 * @param columna posici&oacute;n horizontal de la casilla.
	 */
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
	
	/**
	 * Funci&oacute;n que cambia el color de la casilla a rojo, cambia el cursor a una mano y la marca como seleccionada.
	 */
	public void focus() {
		this.setBackground(color.RED);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.focused = true;
	}

	/**
	 * Funci&oacute;n que deselecciona la casilla, devuelve el cursor a la normalidad y le cambia el color al que tenia al
	 * principio.
	 */
	public void unfocus() {
		this.focused = false;
		this.setBackground(color);
		this.setCursor(Cursor.getDefaultCursor());
		this.repaint();
	}
	
	/**
	 * Funci&oacute;n para agregar una pieza a la casilla.
	 * @param pieza pieza a mover a esta casilla.
	 * @return pieza que ten�a la casilla o null si no ten�a.
	 */
	public Pieza ponerPieza( Pieza pieza ) {
		Pieza piezaDestruida = null;
		if ( this.tienePieza() ) {
			piezaDestruida = this.pieza;
			this.remove(this.pieza);
		}
		this.pieza = pieza;
		this.add(pieza);
		return piezaDestruida;
	}
	
	/**
	 * Funci&oacute;n que quita la pieza de la casilla y la retorna.
	 * @return pieza que tenia la casilla.
	 */
	public Pieza quitarPieza() {
		Pieza piezaQuitada = this.pieza;
		this.pieza = null;
		return piezaQuitada;
	}
	
	/**
	 * Funci&oacute;n que comprueba si la casilla tiene alguna pieza.
	 * @return true si tiene una pieza y false si no.
	 */
	public boolean tienePieza() {
		if ( this.pieza != null ) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Funci&oacute;n que retorna la pieza de la casilla.
	 * @return pieza que tiene la casilla o null si no tiene.
	 */
	public Pieza getPieza() {
		return this.pieza;
	}
	
	/**
	 * Funci&oacute;n que retorna la columna de la casilla.
	 * @return columna de la casilla.
	 */
	public int getColumna() {
		return this.columna;
	}
	
	/**
	 * Funci&oacute;n que retorna la fila de la casilla.
	 * @return fila de la casilla.
	 */
	public int getFila() {
		return this.fila;
	}
	
	/**
	 * Funci&oacute;n est&aacute;tica de {@link Casilla} que asigna las casillas seleccionadas (rojas).
	 * @param casillasRojas casillas seleccionadas.
	 */
	public static void setCasillasRojas( Casilla[] casillasRojas ) {
		Casilla.casillasRojas = casillasRojas;
		for ( Casilla casillaRoja : Casilla.casillasRojas ) {
			if ( casillaRoja != null ) {
				casillaRoja.focus();
			}
		}
	}
	
	/**
	 * Funci&oacute;n que retorna las casillas seleccionadas actualmente.
	 * @return casillas seleccionadas actualmente.
	 */
	public static Casilla[] getCasillasRojas() {
		return casillasRojas;
	}
	
	/**
	 * Funci&oacute;n que comprueba si la casilla est&aacute; seleccionada.
	 * @return true si est&aacute; seleccionada y false si no.
	 */
	public boolean isFocused() {
		return this.focused;
	}
	
	/**
	 * Sobreescritura de la Funci&oacute;n toString que retorna el objeto en forma de string
	 * @return cadena de texto "Casilla [numero de fila] : [ numero de columna ]"
	 */
	public String toString() {
		String frase = "Casilla " + getFila() + ":" + getColumna();
		return frase;
	}
}
