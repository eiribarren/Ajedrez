import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
public class BotonRendirse extends JButton {
    public BotonRendirse(){
        this.setText("Rendirse");
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) { 
                //TODO: PONER METODO QUE FINALIZA LA PARTIDA ACTUAL DE ESTE MISMO INSTANTE INSTANTANEO Y QUE DEFINA QUE EL ETERNO 
            }
        });

    }

}
