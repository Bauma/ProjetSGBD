package vue;

import vue.Panneaux.PanModifierMembre;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;


public class FenModifierMembre extends JFrame {

    private PanModifierMembre panModifMembre ;


    public FenModifierMembre(int id) throws HeadlessException {

        panModifMembre = new PanModifierMembre(id);
        initFrame();
        this.setVisible(true);


    }

    private void initFrame() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(300, 200, 450, 150);
        this.setContentPane(panModifMembre);
    }


}
