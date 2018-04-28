package Juego;
import javax.swing.JLabel;

public abstract class Pieza extends JLabel{
	protected String identificador;
	protected int posicionX;
	protected int posicionY;
	protected String urlImagen;
	public abstract int[][] getMovimientos();
	
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
	
	public String toString() {
		return this.identificador;
	}
}
