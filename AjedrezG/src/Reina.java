
import java.awt.Dimension;
import java.awt.Color;

public class Reina extends Pieza{
	public Reina(Color color) {
		this.setVisible(true);
		if ( color == Color.BLACK ) {
			this.urlImagen = "/ReinaNegra.png";
		} else {
			this.urlImagen = "/ReinaBlanca.png";
		}
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlImagen)));
		this.setPreferredSize(new Dimension(50,50));
	}
	public int[][] getMovimientos(){
		int[][] movimientos = new int[2][2];
		return movimientos;
	}
}
