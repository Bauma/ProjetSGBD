package vue;

import controller.EquipeController;
import vue.Panneaux.PanModifierEquipe;

import java.awt.HeadlessException;
import javax.swing.JFrame;


public class FenModifierEquipe extends JFrame {

    private PanModifierEquipe panModifEquipe ;


    public FenModifierEquipe(int id) throws HeadlessException {

        panModifEquipe = new PanModifierEquipe(id);
        initFrame();
        this.setVisible(true);
    }

    private void initFrame() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(300, 200, 450, 300);
        this.setContentPane(panModifEquipe);
    }

}