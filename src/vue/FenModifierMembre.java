package vue;

import vue.Panneaux.PanModifierMembre;

import java.awt.HeadlessException;
import javax.swing.JFrame;


public class FenModifierMembre extends JFrame {

    private PanModifierMembre panModifMembre ;


    public FenModifierMembre() throws HeadlessException {

        panModifMembre = new PanModifierMembre();
        initFrame();
        this.setVisible(true);
    }

    private void initFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(300, 200, 450, 230);
        this.setContentPane(panModifMembre);
    }

}