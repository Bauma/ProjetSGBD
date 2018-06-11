package vue;

import vue.Panneaux.PanPrincipale;

import java.awt.HeadlessException;
import javax.swing.JFrame;

public class FenPrincipale extends JFrame{

        private PanPrincipale panPrincipale;

        public FenPrincipale() throws HeadlessException {

            panPrincipale = new PanPrincipale();
            initFrame();
            this.setVisible(true);
        }

        private void initFrame() {
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setBounds(1200, 200, 300, 300);
            this.setContentPane(panPrincipale);
        }


    }


