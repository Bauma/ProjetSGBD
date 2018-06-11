package vue;

import vue.Panneaux.PanAfficherMembre;

import java.awt.HeadlessException;
import javax.swing.JFrame;


public class FenAfficherMembre extends JFrame {

    private PanAfficherMembre panAffMembre ;


    public FenAfficherMembre() throws HeadlessException {

        panAffMembre = new PanAfficherMembre();
        initFrame();
        this.setVisible(true);
    }

    private void initFrame() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(300, 200, 900, 650);
        this.setContentPane(panAffMembre);
    }


}
