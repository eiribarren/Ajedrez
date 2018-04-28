package Juego;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Color;

public class Casilla extends JPanel{
	private static final int DEFAULT_WIDTH = 100;
	private static final int DEFAULT_HEIGHT = 100;
	
	public Casilla(Color color) {
		super();
		this.setBackground(color);
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
		this.setMaximumSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
		this.setVisible(true);
	}
}
