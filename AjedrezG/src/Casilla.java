
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
	 * @param fila posición vertical de la casilla.
	 * @param columna posición horizontal de la casilla.
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
	 * Función que cambia el color de la casilla a rojo, cambia el cursor a una mano y la marca como seleccionada.
	 */
	public void focus() {
		this.setBackground(color.RED);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.focused = true;
	}

	/**
	 * Función que deselecciona la casilla, devuelve el cursor a la normalidad y le cambia el color al que tenia al
	 * principio.
	 */
	public void unfocus() {
		this.focused = false;
		this.setBackground(color);
		this.setCursor(Cursor.getDefaultCursor());
		this.repaint();
	}
	
	/**
	 * Función para agregar una pieza a la casilla.
	 * @param pieza pieza a mover a esta casilla.
	 * @return pieza que tenía la casilla o null si no tenía.
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
	 * Función que quita la pieza de la casilla y la retorna.
	 * @return pieza que tenia la casilla.
	 */
	public Pieza quitarPieza() {
		Pieza piezaQuitada = this.pieza;
		this.pieza = null;
		return piezaQuitada;
	}
	
	/**
	 * Función que comprueba si la casilla tiene alguna pieza.
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
	 * Función que retorna la pieza de la casilla.
	 * @return pieza que tiene la casilla o null si no tiene.
	 */
	public Pieza getPieza() {
		return this.pieza;
	}
	
	/**
	 * Función que retorna la columna de la casilla.
	 * @return columna de la casilla.
	 */
	public int getColumna() {
		return this.columna;
	}
	
	/**
	 * Función que retorna la fila de la casilla.
	 * @return fila de la casilla.
	 */
	public int getFila() {
		return this.fila;
	}
	
	/**
	 * Función estática de {@link Casilla} que asigna las casillas seleccionadas (rojas).
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
	 * Función que retorna las casillas seleccionadas actualmente.
	 * @return casillas seleccionadas actualmente.
	 */
	public static Casilla[] getCasillasRojas() {
		return casillasRojas;
	}
	
	/**
	 * Función que comprueba si la casilla está seleccionada.
	 * @return true si está seleccionada y false si no.
	 */
	public boolean isFocused() {
		return this.focused;
	}
	
	/**
	 * Sobreescritura de la función toString que retorna el objeto en forma de string
	 * @return cadena de texto "Casilla [numero de fila] : [ numero de columna ]"
	 */
	public String toString() {
		String frase = "Casilla " + getFila() + ":" + getColumna();
		return frase;
	}
}
