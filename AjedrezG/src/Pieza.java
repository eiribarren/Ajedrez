import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase abstracta que define una pieza para utilizar en alg�n juego.
 * @author Epumer
 *
 */
public abstract class Pieza extends JLabel{
	/**
	 * Cadena de texto identificador sirve para mostrar la pieza en formato de texto.
	 */
	protected String identificador;
	
	/**
	 * Entero columna es la posici�n horizontal de la pieza.
	 */
	protected int columna;
	
	/**
	 * Entero fila es la posici�n vertical de la pieza.
	 */
	protected int fila;
	
	/**
	 * Cadena de texto que indica la ubicaci�n de una imagen para mostrar la pieza.
	 */
	protected String urlImagen;
	
	/**
	 * {@link Color} color que permite diferenciar el bando de las piezas.
	 */
	protected Color color;
	
	/**
	 * Funci�n abstracta que retorna los movimientos que puede hacer la pieza.
	 * @return matriz de movimientos de la pieza.
	 */
	public abstract int[][] getMovimientos();
	
	/**
	 * Funci�n que inicia la pieza, por defecto cambia el cursor a una mano apuntando.
	 */
	public void start() {
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	/**
	 * Funci�n que retorna la columna de la pieza.
	 * @return la columna de la pieza.
	 */
	public int getColumna() {
		return this.columna;
	}
	
	/**
	 * Funci�n que retorna la fila de la pieza.
	 * @return la fila de la pieza.
	 */
	public int getFila() {
		return this.fila;
	}
	
	/**
	 * Funci�n para asignar una posici�n a la pieza.
	 * @param fila la fila a donde queremos mover la pieza.
	 * @param columna la columna a donde queremos mover la pieza.
	 */
	public void setPosicion( int fila, int columna) {
		this.columna = columna;
		this.fila = fila;
	}
	
	/**
	 * Funci�n que retorna el color de la pieza.
	 * @return el color de la pieza.
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Funci�n que convierte la pieza en una cadena de texto.
	 */
	public String toString() {
		return this.identificador;
	}
	
	/**
	 * Funci�n para cambiar el tama�o de la imagen de la pieza.
	 * @param ancho el ancho en pixeles que queremos de medida para la imagen.
	 * @param altura la altura en pixeles que queremos de medida para la imagen.
	 */
	public void cambiarTamano(int ancho, int altura) {
		   Image imagen = new javax.swing.ImageIcon(getClass().getResource(urlImagen)).getImage();
	        
	        BufferedImage bi = new BufferedImage(imagen.getWidth(null), imagen.getHeight(null), BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g = bi.createGraphics();
	        g.drawImage(imagen,0,altura/2,ancho,altura,null);
	        this.setIcon(new ImageIcon(bi));
	}
}
