import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase abstracta que define una pieza para utilizar en alg&uacute;n juego.
 * @author Epumer
 *
 */
public abstract class Pieza extends JLabel{
	/**
	 * Cadena de texto identificador sirve para mostrar la pieza en formato de texto.
	 */
	protected String identificador;
	
	/**
	 * Entero columna es la posici&oacute;n horizontal de la pieza.
	 */
	protected int columna;
	
	/**
	 * Entero fila es la posici&oacute;n vertical de la pieza.
	 */
	protected int fila;
	
	/**
	 * Cadena de texto que indica la ubicaci&oacute;n de una imagen para mostrar la pieza.
	 */
	protected String urlImagen;
	
	/**
	 * {@link Color} color que permite diferenciar el bando de las piezas.
	 */
	protected Color color;
	
	/**
	 * Funci&oacute;abstracta que retorna los movimientos que puede hacer la pieza.
	 * @return matriz de movimientos de la pieza.
	 */
	public abstract int[][] getMovimientos();
	
	/**
	 * Funci&oacute;que inicia la pieza, por defecto cambia el cursor a una mano apuntando.
	 */
	public void start() {
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	/**
	 * Funci&oacute;que retorna la columna de la pieza.
	 * @return la columna de la pieza.
	 */
	public int getColumna() {
		return this.columna;
	}
	
	/**
	 * Funci&oacute;que retorna la fila de la pieza.
	 * @return la fila de la pieza.
	 */
	public int getFila() {
		return this.fila;
	}
	
	/**
	 * Funci&oacute;para asignar una posici&oacute;n a la pieza.
	 * @param fila la fila a donde queremos mover la pieza.
	 * @param columna la columna a donde queremos mover la pieza.
	 */
	public void setPosicion( int fila, int columna) {
		this.columna = columna;
		this.fila = fila;
	}
	
	/**
	 * Funci&oacute;que retorna el color de la pieza.
	 * @return el color de la pieza.
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Funci&oacute;que convierte la pieza en una cadena de texto.
	 */
	public String toString() {
		return this.identificador;
	}
	
	/**
	 * Funci&oacute;para cambiar el tama&ntilde;n de la imagen de la pieza.
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
