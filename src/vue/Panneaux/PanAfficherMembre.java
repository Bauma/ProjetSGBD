package vue.Panneaux;


import controller.MembreController;
import modele.ZModel;
import vue.FenAjouterMembre;
import vue.FenModifierMembre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PanAfficherMembre extends JPanel implements ActionListener {

    private MembreController ctrlMembre;

    private JButton btnModifierMembre = new JButton("Modifier Membre");
    private JButton btnSupprimerMembre = new JButton("Supprimer Membre");
    private JButton btnAjouterMembre = new JButton("Ajouter Membre");

    private JButton btnActualiserMembres = new JButton("Actualiser");



    private JTable tableAfficherResult = new JTable();
    private JScrollPane js = new JScrollPane(tableAfficherResult);



    public PanAfficherMembre() {

        this.ctrlMembre = new MembreController();
        initPanel();
    }

    private void initPanel() {


//Boutons de gestion(GAUCHE)

        btnModifierMembre.setBounds(20, 10, 150, 30);
        btnModifierMembre.addActionListener(this);
        btnModifierMembre.setActionCommand("ModifierMembre");
        this.add(btnModifierMembre);

        btnSupprimerMembre.setBounds(20, 50, 150, 30);
        btnSupprimerMembre.addActionListener(this);
        btnSupprimerMembre.setActionCommand("SupprimerMembre");
        this.add(btnSupprimerMembre);

        btnAjouterMembre.setBounds(20, 90, 150, 30);
        btnAjouterMembre.addActionListener(this);
        btnAjouterMembre.setActionCommand("AjouterMembre");
        this.add(btnAjouterMembre);

//Boutons d'affichages(DROITE)

        btnActualiserMembres.setBounds(710, 90, 150, 30);
        btnActualiserMembres.addActionListener(this);
        btnActualiserMembres.setActionCommand("Actualiser");
        this.add(btnActualiserMembres);


        js.setBounds(20,140,840,440);
        js.setVisible(true);
        this.add(js);


        this.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "AjouterMembre":
                FenAjouterMembre fenAjoutMembre = new FenAjouterMembre();
                break;
            case "ModifierMembre":
                int row = this.tableAfficherResult.getSelectedRow();
                FenModifierMembre fenModifMembre = new FenModifierMembre(row);
                break;

            case "Actualiser":

                Object[][] dataMembre = ctrlMembre.afficherMembre();
                String title[] = {"id", "Pseudo", "Nationalité", "Equipe", "Role"};
                ZModel model = new ZModel(dataMembre, title);
                tableAfficherResult.setModel(model);
                break;

        }
    }


}
