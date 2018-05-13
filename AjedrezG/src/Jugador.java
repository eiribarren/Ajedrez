
import java.awt.Color;
/**
 * Clase jugador para usar en algún juego
 * @author Epumer
 *
 */
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
