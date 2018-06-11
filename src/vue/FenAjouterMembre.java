package vue;

import vue.Panneaux.PanAjouterMembre;

import java.awt.HeadlessException;
import javax.swing.JFrame;


public class FenAjouterMembre extends JFrame {

    private PanAjouterMembre panAjoutMembre ;


    public FenAjouterMembre() throws HeadlessException {

        panAjoutMembre = new PanAjouterMembre();
        initFrame();
        this.setVisible(true);
    }

    private void initFrame() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(300, 200, 450, 130);
        this.setContentPane(panAjoutMembre);
    }

}