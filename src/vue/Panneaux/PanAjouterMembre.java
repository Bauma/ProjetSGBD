package vue.Panneaux;

import controller.MembreController;
import modele.Pays;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;


public class PanAjouterMembre extends JPanel implements ActionListener {

    private MembreController ctrlMembre;

    private JLabel lblPseudo = new JLabel("Pseudo");
    private JLabel lblNationalite = new JLabel("Nationalité");

    private JTextField txtPseudo = new JTextField();
    private JComboBox cbNationalite = new JComboBox();

    private JButton btnAjouter = new JButton("Ajouter");


    public PanAjouterMembre() {
        this.ctrlMembre = new MembreController();
        getForm();
        initPanel();
    }

    private void initPanel() {

        lblPseudo.setBounds(20, 20, 100, 20);
        this.add(lblPseudo);
        lblNationalite.setBounds(20, 50, 100, 20);
        this.add(lblNationalite);


        txtPseudo.setBounds(150, 20, 150, 20);
        txtPseudo.setEditable(true);
        this.add(txtPseudo);


        cbNationalite.setBounds(150, 50, 150, 20);
        cbNationalite.setEditable(true);
        this.add(cbNationalite);


        btnAjouter.setBounds(315, 30, 100, 30);
        btnAjouter.addActionListener(this);
        btnAjouter.setActionCommand("AjouterMembre");
        this.add(btnAjouter);

        this.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "AjouterMembre" :

                ctrlMembre.createMembre(txtPseudo.getText(), ctrlMembre.getIdPaysByName(cbNationalite.getSelectedItem().toString()));
                Container topLevel = this.getTopLevelAncestor();
                JFrame maJFrame = (JFrame) topLevel;
                maJFrame.dispose();
                break;


        }

    }

    public void getForm(){

        Pays[] tabPays = ctrlMembre.getAllPays();

        ArrayList<String> allPays = new ArrayList<>();

        for(Pays pays : tabPays) {
            allPays.add(pays.getNomPays());

        }
        cbNationalite.setModel(new DefaultComboBoxModel(allPays.toArray()));
    }
}
