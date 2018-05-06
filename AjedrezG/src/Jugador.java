
import java.awt.Color;

public class Jugador {
	private String nombre;
	private Color color;
	
	public Jugador(String nombre, Color color) {
		this.nombre = nombre;
		this.color = color;
	}

	public String getNombre() {
		return nombre;
	}

	public Color getColor() {
		return color;
	}
	
	public String toString() {
		return nombre;
	}
}
