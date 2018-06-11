package vue;

import vue.Panneaux.PanAfficherEquipe;

import java.awt.HeadlessException;
import javax.swing.*;


public class FenAfficherEquipe extends JFrame {

    private PanAfficherEquipe panAffEquipe ;


    public FenAfficherEquipe() throws HeadlessException {

        panAffEquipe = new PanAfficherEquipe();
        initFrame();
        this.setVisible(true);
    }

    private void initFrame() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(300, 200, 900, 650);
        this.setContentPane(panAffEquipe);
    }


}
