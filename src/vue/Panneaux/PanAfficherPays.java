package vue.Panneaux;


import controller.PaysController;
import modele.ZModel;

import vue.FenAjouterPays;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class PanAfficherPays extends JPanel implements ActionListener {


    private PaysController ctrlPays;


    private JButton btnSupprimerPays = new JButton("Supprimer Pays");
    private JButton btnAjouterPays = new JButton("Ajouter Pays");

    private JButton btnActualiserPays = new JButton("Actualiser");

    private JTable tableAfficherResult = new JTable();
    private JScrollPane js = new JScrollPane(tableAfficherResult);


    public PanAfficherPays() {
        this.ctrlPays = new PaysController();
        initPanel();
    }

    private void initPanel() {

//Boutons de gestion(GAUCHE)

        btnSupprimerPays.setBounds(20, 50, 150, 30);
        btnSupprimerPays.addActionListener(this);
        btnSupprimerPays.setActionCommand("SupprimerPays");
        this.add(btnSupprimerPays);

        btnAjouterPays.setBounds(20, 90, 150, 30);
        btnAjouterPays.addActionListener(this);
        btnAjouterPays.setActionCommand("AjouterPays");
        this.add(btnAjouterPays);

//Boutons d'affichages(DROITE)

        btnActualiserPays.setBounds(710, 90, 150, 30);
        btnActualiserPays.addActionListener(this);
        btnActualiserPays.setActionCommand("Actualiser");
        this.add(btnActualiserPays);

        js.setBounds(20, 140, 840, 440);
        js.setVisible(true);
        this.add(js);

        this.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "AjouterPays":
                FenAjouterPays fenAjoutPays = new FenAjouterPays();

                break;

            case "Actualiser":

                Object[][] dataPays = ctrlPays.afficherPays();
                String title[] = {"id", "Pays", "Equipe 1", "Equipe 2"};
                ZModel model = new ZModel(dataPays, title);
                tableAfficherResult.setModel(model);
                break;

        }

    }

}







