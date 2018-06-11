package vue;

import vue.Panneaux.PanAfficherPays;

import java.awt.HeadlessException;
import javax.swing.JFrame;


public class FenAfficherPays extends JFrame {

    private PanAfficherPays panAffPays ;


    public FenAfficherPays() throws HeadlessException {

        panAffPays = new PanAfficherPays();
        initFrame();
        this.setVisible(true);
    }

    private void initFrame() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(300, 200, 900, 650);
        this.setContentPane(panAffPays);
    }


}
