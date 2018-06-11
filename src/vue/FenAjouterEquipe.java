package vue;

import vue.Panneaux.PanAjouterEquipe;

import java.awt.HeadlessException;
import javax.swing.JFrame;


public class FenAjouterEquipe extends JFrame {

    private PanAjouterEquipe panAjoutEquipe ;


    public FenAjouterEquipe() throws HeadlessException {

        panAjoutEquipe = new PanAjouterEquipe();
        initFrame();
        this.setVisible(true);
    }

    private void initFrame() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(300, 200, 450, 150);
        this.setContentPane(panAjoutEquipe);
    }


}