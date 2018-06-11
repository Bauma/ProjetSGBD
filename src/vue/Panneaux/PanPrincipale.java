package vue.Panneaux;

import vue.FenAfficherEquipe;
import vue.FenAfficherMembre;
import vue.FenAfficherPays;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanPrincipale extends JPanel implements ActionListener {

    private JButton btnAfficherMembres = new JButton("Afficher Membres");
    private JButton btnAfficherPays = new JButton("Afficher Pays");
    private JButton btnAfficherEquipes = new JButton("Afficher Equipes");

    public PanPrincipale() {

        initPanel();
    }



    private void initPanel() {


//Boutons d'affichages(DROITE)

        btnAfficherMembres.setBounds(10, 50, 260, 40);
        btnAfficherMembres.addActionListener(this);
        btnAfficherMembres.setActionCommand("AfficherMembres");
        this.add(btnAfficherMembres);

        btnAfficherPays.setBounds(10, 100, 260, 40);
        btnAfficherPays.addActionListener(this);
        btnAfficherPays.setActionCommand("AfficherPays");
        this.add(btnAfficherPays);

        btnAfficherEquipes.setBounds(10, 150, 260, 40);
        btnAfficherEquipes.addActionListener(this);
        btnAfficherEquipes.setActionCommand("AfficherEquipes");
        this.add(btnAfficherEquipes);

        this.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "AfficherPays":
                FenAfficherPays fenAffPays = new FenAfficherPays();

                break;
            case "AfficherEquipes":
                FenAfficherEquipe fenAffEquipe = new FenAfficherEquipe();

                break;
            case "AfficherMembres":
                FenAfficherMembre fenAffMembre = new FenAfficherMembre();

                break;

        }
    }
}