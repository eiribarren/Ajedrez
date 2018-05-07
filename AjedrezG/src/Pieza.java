import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Pieza extends JLabel{
	protected String identificador;
	protected int columna;
	protected int fila;
	protected String urlImagen;
	protected Color color;
	public abstract int[][] getMovimientos();
	
	public void start() {
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	public int getColumna() {
		return this.columna;
	}
	
	public int getFila() {
		return this.fila;
	}
	
	public void setPosicion( int fila, int columna) {
		this.columna = columna;
		this.fila = fila;
	}
	
	public Color getColor() {
		return color;
	}
	
	public String toString() {
		return this.identificador;
	}
	public void cambiarTamano(int ancho, int altura) {
		   Image imagen = new javax.swing.ImageIcon(getClass().getResource(urlImagen)).getImage();
	        
	        BufferedImage bi = new BufferedImage(imagen.getWidth(null), imagen.getHeight(null), BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g = bi.createGraphics();
	        g.drawImage(imagen,0,altura/2,ancho,altura,null);
	        this.setIcon(new ImageIcon(bi));
	}
}
