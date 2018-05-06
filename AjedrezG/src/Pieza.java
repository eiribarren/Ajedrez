
import java.awt.Cursor;
import java.awt.Color;
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
}
