package vue.Panneaux;



import controller.EquipeController;
import controller.MembreController;
import controller.PaysController;
import modele.ZModel;
import vue.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PanAfficherEquipe extends JPanel implements ActionListener {

    private EquipeController ctrlEquipe;


    private JButton btnModifierEquipe = new JButton("Modifier Equipe");
    private JButton btnSupprimerEquipe = new JButton("Supprimer Equipe");
    private JButton btnAjouterEquipe = new JButton("Ajouter Equipe");

    private JButton btnActualiserEquipes = new JButton("Actualiser");



    private JTable tableAfficherResult = new JTable();
    private JScrollPane js = new JScrollPane(tableAfficherResult);


    public PanAfficherEquipe() {
        this.ctrlEquipe = new EquipeController();

        initPanel();
    }

    private void initPanel() {

//Boutons de gestion(GAUCHE)

        btnModifierEquipe.setBounds(20, 10, 150, 30);
        btnModifierEquipe.addActionListener(this);
        btnModifierEquipe.setActionCommand("ModifierEquipe");
        this.add(btnModifierEquipe);

        btnSupprimerEquipe.setBounds(20, 50, 150, 30);
        btnSupprimerEquipe.addActionListener(this);
        btnSupprimerEquipe.setActionCommand("SupprimerEquipe");
        this.add(btnSupprimerEquipe);

        btnAjouterEquipe.setBounds(20, 90, 150, 30);
        btnAjouterEquipe.addActionListener(this);
        btnAjouterEquipe.setActionCommand("AjouterEquipe");
        this.add(btnAjouterEquipe);

//Boutons d'affichages(DROITE)

        btnActualiserEquipes.setBounds(710, 90, 150, 30);
        btnActualiserEquipes.addActionListener(this);
        btnActualiserEquipes.setActionCommand("Actualiser");
        this.add(btnActualiserEquipes);


        js.setBounds(20,140,840,440);
        js.setVisible(true);
        this.add(js);

        this.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "AjouterEquipe":
                FenAjouterEquipe fenAjoutEquipe = new FenAjouterEquipe();

                break;
            case "ModifierEquipe":
                int row = this.tableAfficherResult.getSelectedRow();
                FenModifierEquipe fenModifEquipe = new FenModifierEquipe(row);

                break;
            case "SupprimerEquipe":
                int rowToDelete = this.tableAfficherResult.getSelectedRow();
                int idDelete = (int) this.tableAfficherResult.getValueAt(rowToDelete, 0);
                ctrlEquipe.deleteEquipe(idDelete);

                break;

            case "Actualiser":

                Object[][] dataEquipe = ctrlEquipe.afficherEquipe();
                String title[] = {"id", "Nom de l'équipe", "Pays", "Entraineur", "Joueur 1", "Joueur 2", "Joueur 3"};
                ZModel model = new ZModel(dataEquipe, title);
                tableAfficherResult.setModel(model);
                break;

        }
    }


}
