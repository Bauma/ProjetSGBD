package vue;

import vue.Panneaux.PanAjouterPays;

import java.awt.HeadlessException;
import javax.swing.JFrame;


public class FenAjouterPays extends JFrame {

    private PanAjouterPays panAjoutPays ;


    public FenAjouterPays() throws HeadlessException {

        panAjoutPays = new PanAjouterPays();
        initFrame();
        this.setVisible(true);
    }

    private void initFrame() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(300, 200, 450, 100);
        this.setContentPane(panAjoutPays);
    }

}