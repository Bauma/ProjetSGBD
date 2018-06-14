package vue.Panneaux;

import controller.EquipeController;
import controller.MembreController;
import modele.Pays;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;


public class PanAjouterEquipe extends JPanel implements ActionListener {

    private MembreController ctrlMembre;
    private EquipeController ctrlEquipe;

    private JLabel lblNomEquipe = new JLabel("Nom de l'équipe");
    private JLabel lblPaysEquipe = new JLabel("Pays de l'équipe");

    private JTextField txtNomEquipe = new JTextField();
    private JComboBox cbPaysEquipe = new JComboBox();

    private JButton btnAjouter = new JButton("Ajouter");

    public PanAjouterEquipe() {
        this.ctrlMembre = new MembreController();
        this.ctrlEquipe = new EquipeController();
        getForm();
        initPanel();
    }

    private void initPanel() {

        lblNomEquipe.setBounds(20, 20, 100, 20);
        this.add(lblNomEquipe);

        lblPaysEquipe.setBounds(20, 50, 100, 20);
        this.add(lblPaysEquipe);


        txtNomEquipe.setBounds(150, 20, 150, 20);
        txtNomEquipe.setEditable(true);
        this.add(txtNomEquipe);

        cbPaysEquipe.setBounds(150, 50, 150, 20);
        cbPaysEquipe.setEditable(true);
        this.add(cbPaysEquipe);


        btnAjouter.setBounds(315, 30, 100, 30);
        btnAjouter.addActionListener(this);
        btnAjouter.setActionCommand("AjouterEquipe");
        this.add(btnAjouter);


        this.setLayout(null);

    }




    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "AjouterEquipe" :
                ctrlEquipe.createEquipe(txtNomEquipe.getText(),ctrlMembre.getIdPaysByName(cbPaysEquipe.getSelectedItem().toString()));
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
        cbPaysEquipe.setModel(new DefaultComboBoxModel(allPays.toArray()));
    }
}
