import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;

import java.awt.Font;



public class InterfazResolucion extends JFrame {
	public static void main(String[] args) {
		InterfazResolucion interfaz = new InterfazResolucion();
		JPanel maestro = new JPanel();
		
		interfaz.setVisible(true);
		//interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton res1 = new JButton();
		JButton res2 = new JButton();
		res1.setText("Pantalla pequeña");
		res2.setText("Pantalla grande");
		res1.setVisible(true);
		res2.setVisible(true);
		res1.setBounds(550, 50, 10, 35);
		maestro.add(res1);
		maestro.add(res2);
		interfaz.add(maestro);
		
		
	}
	
	public InterfazResolucion() {
		setSize(500,300);
	}
}
