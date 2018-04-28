package Juego;
import java.awt.Cursor;
import java.awt.Color;
import javax.swing.JLabel;

public abstract class Pieza extends JLabel{
	protected String identificador;
	protected int posicionX;
	protected int posicionY;
	protected String urlImagen;
	protected Color color;
	
	public abstract int[][] getMovimientos();
	
	public void start() {
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	public int getPosicionX() {
		return this.posicionX;
	}
	
	public int getPosicionY() {
		return this.posicionY;
	}
	
	public void setPosicion( int posicionX, int posicionY) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}
	
	public Color getColor() {
		return color;
	}
	
	public String toString() {
		return this.identificador;
	}
}
